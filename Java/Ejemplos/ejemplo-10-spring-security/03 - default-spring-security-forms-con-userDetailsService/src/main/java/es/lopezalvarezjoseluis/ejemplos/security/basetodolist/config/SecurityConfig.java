package es.lopezalvarezjoseluis.ejemplos.security.basetodolist.config;

import es.lopezalvarezjoseluis.ejemplos.security.basetodolist.services.AppUserDetailsService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http, AppUserDetailsService appUserDetailsService) throws Exception {
        http
                .authorizeHttpRequests(auth -> auth
                        .anyRequest().authenticated()   // Todas las peticiones autenticadas
                )
                .formLogin(Customizer.withDefaults()) // Usa el formulario por defecto
                .userDetailsService(appUserDetailsService); // Usar el servicio de usuarios creado
        return http.build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        // Deprecado para avisar de que es inseguro, pero no se va a eliminar.
        return NoOpPasswordEncoder.getInstance();
    }
}
