package es.lopezalvarezjoseluis.ejemplos.security.basetodolist.config;

import es.lopezalvarezjoseluis.ejemplos.security.basetodolist.filters.HasCustomHeaderFilter;
import es.lopezalvarezjoseluis.ejemplos.security.basetodolist.filters.TimeMeasuringFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.stereotype.Component;


@Configuration
public class SecurityConfig {


    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http,
                                                   TimeMeasuringFilter timeMeasuringFilter,
                                                   HasCustomHeaderFilter hasCustomHeaderFilter) throws Exception {
        return http
                // Permitir acceso anónimo a todo el sitio
                .authorizeHttpRequests(auth -> auth.anyRequest().permitAll())
                // Añadir un filtro para que haga algo antes y después de cada petición (medir tiempo de ejecución).
                .addFilterBefore(timeMeasuringFilter, UsernamePasswordAuthenticationFilter.class)
                // Y otro para que exija una cabecera en las peticiones
                .addFilterAfter(hasCustomHeaderFilter, TimeMeasuringFilter.class)
                // .addFilterBefore(hasCustomHeaderFilter, UsernamePasswordAuthenticationFilter.class)
                .build();
    }
}
