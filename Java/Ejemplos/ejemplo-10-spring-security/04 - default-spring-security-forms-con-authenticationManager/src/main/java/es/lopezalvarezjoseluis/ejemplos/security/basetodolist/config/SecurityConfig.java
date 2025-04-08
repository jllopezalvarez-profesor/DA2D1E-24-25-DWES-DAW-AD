package es.lopezalvarezjoseluis.ejemplos.security.basetodolist.config;

import es.lopezalvarezjoseluis.ejemplos.security.basetodolist.services.AppUserDetailsService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.ProviderManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class SecurityConfig {
    // De nuevo, como no se está cambiando la configuración de filtros por defecto,
    // no hace falta crear una cadena de filtros de seguridad personalizada
//    @Bean
//    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
//        http
//                .authorizeHttpRequests(auth -> auth
//                        .anyRequest().authenticated()   // Todas las peticiones autenticadas
//                )
//                .formLogin(Customizer.withDefaults()); // Usa el formulario por defecto
//        return http.build();
//    }


    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration config
            , AppUserDetailsService userDetailsService) throws Exception {
        // Crear AuthenticationProvider, que se encargará de identificar a los usuarios.
        // El Provider usa el UserDetailsService para buscar usuarios, y el PasswordEncoder
        // para codificar y verificar contraseñas.
        DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
        authProvider.setUserDetailsService(userDetailsService);
        authProvider.setPasswordEncoder(passwordEncoder());

        // Aquí podrían crearse otros AuthenticationProviders.

        // Crear y devolver el AuthenticationManager que, usando los providers indicados,
        // se encargue de "disparar" la autenticación. En este caso es solo uno, pero el
        // constructor admite un número indefinido.
        return new ProviderManager(authProvider);
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        // Deprecado para avisar de que es inseguro, pero no se va a eliminar.
        return NoOpPasswordEncoder.getInstance();
    }


}
