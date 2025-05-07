package es.lopezalvarezjoseluis.ejemplos.security.basetodolist.services;

import es.lopezalvarezjoseluis.ejemplos.security.basetodolist.dto.JwtTokensDto;
import es.lopezalvarezjoseluis.ejemplos.security.basetodolist.dto.LoginUserDto;
import es.lopezalvarezjoseluis.ejemplos.security.basetodolist.dto.RegisterUserDto;
import es.lopezalvarezjoseluis.ejemplos.security.basetodolist.entities.AppUser;
import es.lopezalvarezjoseluis.ejemplos.security.basetodolist.repositories.AppUserRepository;
import io.jsonwebtoken.JwtException;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Implementación del servicio de autenticación.
 * <p>
 * Este servicio se encarga de manejar el registro y el inicio de sesión de los usuarios,
 * generando los tokens de acceso y refresco necesarios para la autenticación en la API.
 * </p>
 * <p>
 * Los métodos de este servicio interactúan con el servicio de usuarios {@link AppUserService}
 * y el servicio de JWT {@link JwtService} para realizar las operaciones necesarias.
 * </p>
 */
@Service
public class AuthServiceImpl implements AuthService {
    private final AppUserService appUserService;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;
    private final AppUserRepository appUserRepository;

    /**
     * Constructor de {@link AuthServiceImpl} que inyecta las dependencias necesarias.
     *
     * @param appUserService        servicio de usuarios para gestionar el registro y obtención de datos de los usuarios.
     * @param jwtService            servicio para generar los tokens JWT.
     * @param authenticationManager administrador de autenticación para verificar las credenciales de los usuarios.
     */
    public AuthServiceImpl(AppUserService appUserService, JwtService jwtService, AuthenticationManager authenticationManager, AppUserRepository appUserRepository) {
        this.appUserService = appUserService;
        this.jwtService = jwtService;
        this.authenticationManager = authenticationManager;
        this.appUserRepository = appUserRepository;
    }

    /**
     * Registra un nuevo usuario y genera los tokens de acceso y refresco para la autenticación.
     *
     * @param registerUserDto DTO que contiene los datos necesarios para registrar un nuevo usuario.
     * @return un {@link JwtTokensDto} con los tokens de acceso y refresco generados.
     */
    @Override
    @Transactional
    public JwtTokensDto register(RegisterUserDto registerUserDto) {
        // Se registra al usuario con el servicio de usuarios.
        AppUser appUser = appUserService.register(registerUserDto);

        // Generar tokens de acceso y refresco
        String accessToken = jwtService.generateAccessToken(appUser);
        String refreshToken = jwtService.generateRefreshToken(appUser);
        // Construir y devolver el DTO adecuado.
        return JwtTokensDto.builder()
                .accessToken(accessToken)
                .refreshToken(refreshToken)
                .build();
    }

    /**
     * Realiza el inicio de sesión de un usuario, verificando sus credenciales y generando los tokens.
     *
     * @param loginUserDto DTO que contiene las credenciales (correo y contraseña) del usuario para iniciar sesión.
     * @return un {@link JwtTokensDto} con los tokens de acceso y refresco generados para el usuario autenticado.
     */
    @Override
    @Transactional
    public JwtTokensDto login(LoginUserDto loginUserDto) {
        // Se crea un objeto con el nombre de usuario y contraseña para lanzar la autenticación
        UsernamePasswordAuthenticationToken authenticationToken =
                new UsernamePasswordAuthenticationToken(loginUserDto.getEmail(), loginUserDto.getPassword());
        // Internamente, la autenticación usa el AuthenticationProvider que a su vez usa el servicio
        // AppUserDetailsService y el PasswordEncoder.
        // Lanzará excepciones si no existe el usuario o si la contraseña no es correcta.
        authenticationManager.authenticate(authenticationToken);
        // Obtenemos el usuario usando el servicio de usuarios.
        AppUser appUser = appUserService.findByEmail(loginUserDto.getEmail())
                .orElseThrow(() -> new UsernameNotFoundException(String.format("User %s not found", loginUserDto.getEmail())));
        // Generar tokens de acceso y refresco
        String accessToken = jwtService.generateAccessToken(appUser);
        String refreshToken = jwtService.generateRefreshToken(appUser);
        // Construir y devolver el DTO adecuado.
        return JwtTokensDto.builder()
                .accessToken(accessToken)
                .refreshToken(refreshToken)
                .build();
    }

    @Override
    public JwtTokensDto refresh(String authHeader) {
        // Si no hay cabecera de autorización, o si no empieza con "Bearer", no se puede acceder
        if (authHeader == null || !authHeader.startsWith("Bearer ")) {
            throw new JwtException("Authorization header missing or incorrect.");
        }

        // Extraer el token, eliminando "Bearer "
        String token = authHeader.substring(7);

        // Validar el token (lanza excepción si hay algún problema).
        // Específicamente, la renovación exige token de refresco, no vale uno de acceso.
        jwtService.validateRefreshToken(token);

        // Una vez validado, se extrae el nombre de usuario del token
        String username = jwtService.extractUsername(token);

        // Se busca el usuario en la BD.
        AppUser appUser = appUserService.findByEmail(username)
                .orElseThrow(() -> new UsernameNotFoundException(String.format("User %s not found", username)));

        // Generar tokens de acceso y refresco
        String accessToken = jwtService.generateAccessToken(appUser);
        String refreshToken = jwtService.generateRefreshToken(appUser);

        // Construir y devolver el DTO adecuado.
        return JwtTokensDto.builder()
                .accessToken(accessToken)
                .refreshToken(refreshToken)
                .build();
    }

    @Override
    public Long getCurrentAppUserId() {
        return this.getCurrentAppUser().getUserId();
    }

    @Override
    public AppUser getCurrentAppUser() {
        // Obtener cual es el usuario logado
        String userName = SecurityContextHolder.getContext().getAuthentication().getName();
        // buscar el usuario en el repositorio
        return appUserRepository.findByEmail(userName).orElseThrow(() ->
                new UsernameNotFoundException(String.format("User %s not found", userName)));
    }
}

