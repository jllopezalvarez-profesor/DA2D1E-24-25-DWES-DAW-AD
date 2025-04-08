package es.lopezalvarezjoseluis.ejemplos.security.basetodolist.filters;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.http.HttpStatus;
import org.springframework.lang.NonNullApi;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;
import org.springframework.web.server.ResponseStatusException;

import java.io.IOException;

@Component
public class HasCustomHeaderFilter extends OncePerRequestFilter {
    @Override
    protected void doFilterInternal(HttpServletRequest request,  HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        // Obtener la ruta de la petición actual, para poder filtrar solo algunas de las peticiones.
        String requestPath = request.getRequestURI();

        // Ejemplo: que el filtro sólo aplique a las URL que comienzan por /api/
        if (requestPath.startsWith("/api/")) {

            // Obtener el valor de una cabecera. Ejemplo: cabecera personalizada "X-Custom-Header"
            String clave = request.getHeader("X-Custom-Header");

            // Si no existe la cabecera, o si la cabecera no tiene el valor correcto, se rechaza o redirige la petición.
            if (clave == null || !clave.equals("password-en-cabecera")) {
                // Se pueden hacer varias cosas, de varias formas:
                System.out.println("🚫 Falta la cabecera 'X-Custom-Header' o es incorrecta.");

                // Usar response.sendError, y salil:
                response.sendError(HttpServletResponse.SC_FORBIDDEN, "Falta la cabecera X-Clave-Segura");
                return;

                // - Lanzar una excepcion (ojo, esto devuelve un 500 por defecto, no un 401 / 403):
                // throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "No autorizado - No existe la cabecera");


                // Trabajar a bajo nivel y generar la respuesta, y salir.
                // response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
                // response.setContentType("application/json");
                // response.getWriter().write("{\"error\": \"Acceso no autorizado\"}");
                // response.getWriter().flush();
                // return;

                // "Limpiar" el contexto de seguridad y redirigir, para después salir.
                // SecurityContextHolder.clearContext();
                // response.sendRedirect("/login");
                // return;
            }
        }

        // Si no se tenía que aplicar el filtro, o si se ha superado con éxito, se pasa al siguiente filtro de la cadena.
        filterChain.doFilter(request, response);
    }
}
