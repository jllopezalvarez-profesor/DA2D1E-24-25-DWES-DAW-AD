package es.lopezalvarezjoseluis.ejemplos.security.basetodolist.services;

import es.lopezalvarezjoseluis.ejemplos.security.basetodolist.entities.AppUser;
import es.lopezalvarezjoseluis.ejemplos.security.basetodolist.repositories.AppUserRepository;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collections;

@Service
public class AppUserDetailsService implements UserDetailsService {
    private final AppUserRepository appUserRepository;

    public AppUserDetailsService(AppUserRepository appUserRepository) {
        this.appUserRepository = appUserRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        AppUser appUser = appUserRepository.findByEmail(username).orElseThrow(() -> new UsernameNotFoundException("No existe el usuario " + username));
        // return new User(appUser.getEmail(), appUser.getPassword(), Collections.emptyList());
        return User.withUsername(appUser.getEmail())
                .password(appUser.getPassword())
                // .roles("ROL 1", "ROL 2") // Si hay roles, se pueden poner aquí.
                .build();
    }
}
