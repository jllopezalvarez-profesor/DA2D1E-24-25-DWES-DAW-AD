package es.lopezalvarezjoseluis.ejemplos.security.basetodolist.services;

import es.lopezalvarezjoseluis.ejemplos.security.basetodolist.entities.AppUser;
import es.lopezalvarezjoseluis.ejemplos.security.basetodolist.repositories.AppUserRepository;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * Servicio que implementa {@link UserDetailsService} para cargar detalles de un usuario basado en su nombre de usuario.
 * <p>
 * Este servicio es utilizado por Spring Security para autenticar usuarios y cargar sus detalles cuando intentan
 * iniciar sesión. En este caso, la autenticación se realiza utilizando el correo electrónico como nombre de usuario.
 * </p>
 * <p>
 * La clase utiliza el repositorio {@link AppUserRepository} para obtener el usuario desde la base de datos.
 * Si el usuario no se encuentra, se lanza una excepción {@link UsernameNotFoundException}.
 * </p>
 */
@Service
public class AppUserDetailsService implements UserDetailsService {
    private final AppUserRepository appUserRepository;

    public AppUserDetailsService(AppUserRepository appUserRepository) {
        this.appUserRepository = appUserRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // Buscar el usuario con el servicio / repositorio de usuarios de la aplicación
        // usando como username lo que se haya establecido. En este caso se busca por email
        AppUser appUser = appUserRepository
                .findByEmail(username)
                .orElseThrow(
                        () -> new UsernameNotFoundException(String.format("User '%s' not found", username))
                );

        // Se puede devolver cualquier objeto que implemente UserDetails.
        // En este caso se usa la clase "User" que forma parte de Spring Security.
        return User.builder()
                .username(username)
                .password(appUser.getPassword())
                //.roles("USER")
                .build();
    }
}
