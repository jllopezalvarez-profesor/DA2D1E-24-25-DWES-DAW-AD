package es.lopezalvarezjoseluis.ejemplos.security.basetodolist.config;

import es.lopezalvarezjoseluis.ejemplos.security.basetodolist.services.AppUserDetailsService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.ProviderManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;


/**
 * Configuración global de seguridad.
 * <p>
 * Esta clase define beans comunes que pueden ser utilizados por múltiples
 * configuraciones de seguridad (`SecurityFilterChain`) dentro de la aplicación.
 * Se recomienda separar estos beans para evitar duplicación de código cuando
 * se utilizan varios contextos de seguridad, como APIs y vistas web.
 * </p>
 *
 * <p>Los beans definidos en esta clase incluyen:</p>
 * <ul>
 *     <li>{@link PasswordEncoder} para codificar contraseñas de forma segura con BCrypt.</li>
 *     <li>{@link UserDetailsService} para recuperar información de los usuarios autenticados.</li>
 *     <li>{@link AuthenticationProvider} configurado con {@code UserDetailsService} y {@code PasswordEncoder}.</li>
 * </ul>
 *
 * <p>Todos los beans definidos aquí se registran en el contexto global de Spring,
 * por lo que están disponibles para todas las clases que los necesiten.</p>
 */
@Configuration
@Order(2)
public class GlobalSecurityConfig {
    /**
     * Crea el componente "AuthenticationManager", que será el encargado de autenticar a los usuarios.
     * Crea también el "AuthenticationProvider", que será el encargado de autenticar a los usuarios de la BD
     *
     * @param appUserDetailsService servicio (componente inyectado) para buscar detalles de usuario en la BD
     * @param passwordEncoder       servicio (componente inyectado) para poder codificar contraseñas.
     * @return servicio (componente inyectable) para autenticar usuarios.
     */
    @Bean
    public AuthenticationManager authenticationManager(AppUserDetailsService appUserDetailsService, PasswordEncoder passwordEncoder) {
        DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
        provider.setUserDetailsService(appUserDetailsService);
        provider.setPasswordEncoder(passwordEncoder);
        return new ProviderManager(provider);
    }

    /**
     * Crea un componente {@link PasswordEncoder} que utiliza el algoritmo BCrypt.
     * <p>
     * Este componente se usa para codificar contraseñas antes de almacenarlas,
     * y para verificar contraseñas durante el proceso de autenticación.
     *
     * @return una instancia de {@link BCryptPasswordEncoder}.
     */
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }


}
