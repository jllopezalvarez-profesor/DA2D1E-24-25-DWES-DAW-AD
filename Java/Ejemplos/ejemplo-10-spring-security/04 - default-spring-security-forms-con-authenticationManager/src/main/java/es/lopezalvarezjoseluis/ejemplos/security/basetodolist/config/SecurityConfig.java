package es.lopezalvarezjoseluis.ejemplos.security.basetodolist.config;

import es.lopezalvarezjoseluis.ejemplos.security.basetodolist.services.AppUserDetailsService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import java.util.Random;

@Configuration
public class SecurityConfig {
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests(auth -> auth
                        .anyRequest().authenticated()   // Todas las peticiones autenticadas
                )
                .formLogin(Customizer.withDefaults()); // Usa el formulario por defecto
        return http.build();
    }

    @Bean
    public AuthenticationProvider authenticationProvider(AppUserDetailsService appUserDetailsService) {
        DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
        authProvider.setUserDetailsService(appUserDetailsService);
        authProvider.setPasswordEncoder(passwordEncoder());
        return authProvider;
    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration config) throws Exception {
        return config.getAuthenticationManager(); // Usa el provider definido en el @Bean anterior
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        // Deprecado para avisar de que es inseguro, pero no se va a eliminar.
        return NoOpPasswordEncoder.getInstance();
    }


}
