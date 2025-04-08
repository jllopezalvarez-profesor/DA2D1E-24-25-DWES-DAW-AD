package es.lopezalvarezjoseluis.ejemplos.security.basetodolist.services;

import es.lopezalvarezjoseluis.ejemplos.security.basetodolist.entities.AppUser;
import es.lopezalvarezjoseluis.ejemplos.security.basetodolist.repositories.AppUserRepository;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

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

        return User.builder()
                .username(username)
                .password(appUser.getPassword())
                //.roles("USER")
                .build();
    }
}
