package es.lopezalvarezjoseluis.ejemplos.security.basetodolist.filters;

import es.lopezalvarezjoseluis.ejemplos.security.basetodolist.services.JwtService;
import es.lopezalvarezjoseluis.ejemplos.security.basetodolist.utils.ProblemDetailsUtils;
import io.jsonwebtoken.JwtException;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.lang.NonNull;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Component
public class JwtAuthenticationFilter extends OncePerRequestFilter {
    private final JwtService jwtService;
    private final UserDetailsService userDetailsService;

    public JwtAuthenticationFilter(JwtService jwtService, UserDetailsService userDetailsService) {
        this.jwtService = jwtService;
        this.userDetailsService = userDetailsService;
    }



    // El mensaje "Not annotated parameter overrides @NonNullApi parameter" que aparecer porque el paquete
    // de Spring donde se define doFilterInternal () está marcado como @NonNullApi. El paquete completo. Esto
    // significa que todos los parámetros y retornos de todos los métodos son no nulos por defecto, salvo que
    // se indique lo contrario. Esta anotación @NonNullApi está deprecada. Según el propio código de Spring,
    // Ahora hay que usar otras.
    // https://github.com/spring-projects/spring-framework/blob/main/spring-core/src/main/java/org/springframework/lang/NonNullApi.java
    @Override
    protected void doFilterInternal(HttpServletRequest request,
                                    @NonNull HttpServletResponse response,
                                    @NonNull FilterChain filterChain) throws ServletException, IOException {

        // Primero, obtener la ruta de la petición
        String pathRequest = request.getRequestURI();

        // Solo aplica en las rutas que queremos proteger con este filtro.
        if (pathRequest.contains("/api/v1/tasks")) {
            // En el try se hacen varias cosas que pueden lanzar excepción.
            // Si cualquiera de ellas falla, se deniega el acceso.
            try {
                // Extraer cabecera de autorización
                String authHeader = request.getHeader("Authorization");

                // Si no hay cabecera de autorización, o si no empieza con "Bearer", no se puede acceder
                if (authHeader == null || !authHeader.startsWith("Bearer ")) {
                    throw new JwtException("Authorization header missing or incorrect.");
                }

                // Extraer el token, eliminando "Bearer "
                String token = authHeader.substring(7);

                // Validar el token (lanza excepción si hay algún problema).
                // Específicamente, el filtro exige token de acceso, no vale uno de refresco.
                jwtService.validateAccessToken(token);

                // Una vez validado, se extrae el nombre de usuario del token
                String username = jwtService.extractUsername(token);

                // Hay que establecer en el contexto de seguridad quién es el usuario conectado. Para esto:
                // - Se obtienen los detalles del usuario con el servicio "userDetailsService"
                // - Se crea un objeto de tipo authentication. En este caso, UsernamePasswordAuthenticationToken.
                //   Se usa null para credenciales (contraseña) porque confiamos en el token JWT recibido.
                // - Se usa este objeto para fijar el usuario en el contexto de seguridad.
                UserDetails userDetails = userDetailsService.loadUserByUsername(username);
                // Importante: aunque no haya roles en la aplicación, hay que pasar el tercer parámetro del constructor,
                // con los roles del usuario (aunque estén vacíos). Si no, se devolverá un 403 aunque el token sea válido.
                Authentication authentication = new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
                SecurityContextHolder.getContext().setAuthentication(authentication);
            } catch (Exception e) {
                // Generar un "ProblemDetails" para la respuesta.
                String errorMessage = String.format("Error validating access token: %s", e.getMessage());
                ProblemDetailsUtils.writeUnauthorized(response, request, errorMessage);
                // Se "corta" la cadena de filtros, al no llamar a filterChain.doFilter
                return;
            }
        }

        // Se puede llegar aquí porque ha ido bien, o porque no aplicaba esta autenticación.
        // En cualquiera de los dos casos, se "pasa la pelota" al siguiente filtro.
        filterChain.doFilter(request, response);
    }
}
