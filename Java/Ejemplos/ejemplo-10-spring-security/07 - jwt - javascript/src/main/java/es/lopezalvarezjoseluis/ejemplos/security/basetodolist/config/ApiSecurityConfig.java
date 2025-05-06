package es.lopezalvarezjoseluis.ejemplos.security.basetodolist.config;

import es.lopezalvarezjoseluis.ejemplos.security.basetodolist.filters.JwtAuthenticationFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

/**
 * Configuración de seguridad para las rutas de la API.
 * <p>
 * Esta clase configura las políticas de seguridad específicas para las rutas de la API,
 * desactivando las características no necesarias como CSRF, sesiones, autenticación por formularios
 * y autenticación básica. Además, se establece un filtro personalizado para validar los tokens JWT
 * en las solicitudes entrantes.
 * </p>
 * <p>
 * La configuración se aplica únicamente a las rutas que coinciden con "/api/**".
 * </p>
 *
 * <p>Los aspectos configurados incluyen:</p>
 * <ul>
 *     <li>Desactivación de CSRF, ya que no se requiere para APIs REST.</li>
 *     <li>Configuración de sesiones sin estado (stateless) para el manejo adecuado de las API.</li>
 *     <li>Desactivación de autenticación por formularios y básica, ya que se usará autenticación con JWT.</li>
 *     <li>Protección de rutas específicas, como "/api/v1/tasks/**", con autenticación necesaria.</li>
 *     <li>Adición de un filtro JWT personalizado en la cadena de filtros de seguridad.</li>
 * </ul>
 *
 * @see JwtAuthenticationFilter
 */
@Configuration
@Order(3)
public class ApiSecurityConfig {
    /**
     * Configura la cadena de filtros de seguridad para las rutas de la API.
     * <p>
     * Esta configuración se aplica exclusivamente a las rutas que coinciden con "/api/**".
     * Se desactiva CSRF, se configura el manejo de sesiones como sin estado (stateless),
     * y se desactivan las formas de autenticación como el login por formulario y autenticación básica.
     * </p>
     * <p>
     * Se especifica que las rutas de "/api/v1/tasks/**" requieren autenticación y el resto de las rutas
     * son accesibles sin restricciones.
     * </p>
     *
     * @param http                    instancia de {@link HttpSecurity} utilizada para configurar las políticas de seguridad.
     * @param jwtAuthenticationFilter filtro personalizado que valida los tokens JWT en las solicitudes entrantes.
     * @return un {@link SecurityFilterChain} configurado para las rutas de la API.
     * @throws Exception si ocurre algún error durante la configuración de la seguridad.
     */
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http, JwtAuthenticationFilter jwtAuthenticationFilter) throws Exception {

        // Este contexto (securityFilterChain) de seguridad sólo aplicará a lo que esté en la API
        http.securityMatcher("/api/**");

        // Desactivar CSRF en este contexto
        // CSRF es una protección para formularios, así que aquí no aplicaría.
        // Como este contexto solo aplica a API, se puede desactivar completamente.
        // En casos en que no se quiera desactivar completamente, se puede usar
        // http.csrf(config -> config.ignoringRequestMatchers("/ruta/donde/desactivar")
        http.csrf(AbstractHttpConfigurer::disable);

        // Configurar sesiones sin estado (desactivar sesiones) en este contexto.
        // Las API son por definición stateless.
        http.sessionManagement(config -> config
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS));

        // Desactivar autenticación por formularios en este contexto
        http.formLogin(AbstractHttpConfigurer::disable);

        // Desactivar autenticación básica en este contexto
        http.httpBasic(AbstractHttpConfigurer::disable);

        // Indicar qué rutas se quieren proteger y cuales no.
        // Esto se suele hacer de una de estas dos formas:
        // - Indicar las protegidas, y acabar con .anyRequest().permitAll() (la mayoría abierto y se restringe algo)
        // - Indicar las desprotegidas, y acabar con .anyRequest().authenticated() (mayoría cerrado y se permite algo)
        http.authorizeHttpRequests(auth -> auth
//                .requestMatchers("/api/v1/auth/**").permitAll()
//                .anyRequest().authenticated()
                .requestMatchers("/api/v1/tasks/**").authenticated()
                .anyRequest().permitAll());

        // Añadir en la cadena de filtros el filtro que validará el token JWT si llega en las peticiones.
        http.addFilterBefore(jwtAuthenticationFilter, UsernamePasswordAuthenticationFilter.class);

        // Se devuelve la cadena de filtros / configuración
        return http.build();
    }
}
