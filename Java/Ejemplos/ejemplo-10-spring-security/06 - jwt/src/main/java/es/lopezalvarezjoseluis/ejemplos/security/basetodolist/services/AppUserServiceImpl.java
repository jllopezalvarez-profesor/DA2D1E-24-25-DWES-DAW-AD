package es.lopezalvarezjoseluis.ejemplos.security.basetodolist.services;

import es.lopezalvarezjoseluis.ejemplos.security.basetodolist.dto.RegisterUserDto;
import es.lopezalvarezjoseluis.ejemplos.security.basetodolist.entities.AppUser;
import es.lopezalvarezjoseluis.ejemplos.security.basetodolist.exceptions.UserNameAlreadyExistsException;
import es.lopezalvarezjoseluis.ejemplos.security.basetodolist.repositories.AppUserRepository;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AppUserServiceImpl implements AppUserService {
    private final AppUserRepository appUserRepository;
    private final PasswordEncoder passwordEncoder;

    public AppUserServiceImpl(AppUserRepository appUserRepository, PasswordEncoder passwordEncoder, AuthenticationManager authenticationManager) {
        this.appUserRepository = appUserRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public AppUser register(RegisterUserDto registerUserDto) {
        // Se comprueba si existe el usuario. Si ya existe se lanza excepción.
        if (appUserRepository.existsByEmail(registerUserDto.getEmail())) {
            throw new UserNameAlreadyExistsException(registerUserDto.getEmail());
        }

        // Crear el usuario, codificando la contraseña.
        AppUser appUser = AppUser.builder()
                .email(registerUserDto.getEmail())
                .password(passwordEncoder.encode(registerUserDto.getPassword()))
                .firstName(registerUserDto.getFirstName())
                .lastName(registerUserDto.getLastName())
                .build();

        // Guardar y devolver el usuario en el repositorio.
        return appUserRepository.save(appUser);
    }

    @Override
    public Optional<AppUser> findByEmail(String email) {
        return appUserRepository.findByEmail(email);
    }

    @Override
    public AppUser save(AppUser user) {
        return appUserRepository.save(user);
    }

    @Override
    public List<AppUser> findAll() {
        return appUserRepository.findAll();
    }
}
