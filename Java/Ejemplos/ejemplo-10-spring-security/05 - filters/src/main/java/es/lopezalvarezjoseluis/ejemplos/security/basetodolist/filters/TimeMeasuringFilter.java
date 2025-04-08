package es.lopezalvarezjoseluis.ejemplos.security.basetodolist.filters;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Component
public class TimeMeasuringFilter extends OncePerRequestFilter {
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        // Antes de ejecutar el controlador
        long inicio = System.currentTimeMillis();
        System.out.println("🟢 Antes - " + request.getMethod() + " " + request.getRequestURI());

        // Ejecuta la cadena de filtros, pasando al siguiente filtro (incluye el controlador)
        filterChain.doFilter(request, response);

        // Después de ejecutar el controlador (y antes de enviar la respuesta al cliente)
        // En este punto, aunque no se ha enviado la respuesta al cliente, ya está generada.
        // No se puede cambiar nada. Si se cambia puede (depende de varios factores):
        // - Producirse un error de tipo "IllegalStateException"
        // - Que la modificación de la respuesta no haga nada, que se ignore.
        // Hay opciones para modificar la respuesta en este punto: ResponseWrapper, HandlerInterceptor.
        long fin = System.currentTimeMillis();
        System.out.println("🔴 Después - Tiempo: " + (fin - inicio) + " ms");
    }
}
