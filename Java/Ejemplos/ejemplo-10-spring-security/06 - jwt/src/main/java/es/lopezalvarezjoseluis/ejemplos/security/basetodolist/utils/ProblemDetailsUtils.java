package es.lopezalvarezjoseluis.ejemplos.security.basetodolist.utils;

import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;

import java.io.IOException;
import java.net.URI;

/**
 * Clase de utilidad para la creación y escritura de detalles de problemas (Problem Details) en las respuestas HTTP.
 * <p>
 * Esta clase proporciona métodos estáticos para generar y escribir respuestas con detalles de errores en formato
 * "Problem Details" (RFC 9457 / 7807) para los casos de error HTTP más comunes, como la autenticación no autorizada
 * (401 Unauthorized) y el acceso prohibido (403 Forbidden).
 * </p>
 * <p>
 * La clase utiliza un {@link ObjectMapper} para convertir los objetos {@link ProblemDetail} a formato JSON y enviarlos
 * como respuesta con el encabezado `Content-Type` adecuado.
 * </p>
 */
public class ProblemDetailsUtils {

    // Instancia del ObjectMapper para convertir objetos en formato JSON
    private static final ObjectMapper objectMapper = new ObjectMapper();

    /**
     * Escribe una respuesta con un detalle de problema indicando que el usuario no está autorizado (HTTP 401).
     * <p>
     * Genera un {@link ProblemDetail} para el error HTTP 401 (Unauthorized) y lo escribe en la respuesta
     * HTTP. El detalle del problema se pasa como parámetro, y el URI de la solicitud se utiliza para identificar el
     * recurso relacionado con el error.
     * </p>
     *
     * @param response la respuesta HTTP donde se escribirá el detalle del problema.
     * @param request la solicitud HTTP original para obtener el URI y otros detalles.
     * @param detail el detalle del problema (mensaje específico sobre la causa del error).
     * @throws IOException si ocurre un error al escribir el detalle en la respuesta.
     */
    public static void writeUnauthorized(HttpServletResponse response, HttpServletRequest request, String detail) throws IOException {
        ProblemDetail problem = ProblemDetail.forStatus(HttpStatus.UNAUTHORIZED);
        problem.setTitle("Unauthorized");
        problem.setDetail(detail);
        problem.setType(URI.create("urn:problem-type:unauthorized"));
        problem.setInstance(URI.create(request.getRequestURI()));

        response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
        response.setContentType("application/problem+json");
        objectMapper.writeValue(response.getWriter(), problem);
    }

    /**
     * Escribe una respuesta con un detalle de problema indicando que el acceso al recurso está prohibido (HTTP 403).
     * <p>
     * Genera un {@link ProblemDetail} para el error HTTP 403 (Forbidden) y lo escribe en la respuesta
     * HTTP. El detalle del problema se pasa como parámetro, y el URI de la solicitud se utiliza para identificar el
     * recurso relacionado con el error.
     * </p>
     *
     * @param response la respuesta HTTP donde se escribirá el detalle del problema.
     * @param request la solicitud HTTP original para obtener el URI y otros detalles.
     * @param detail el detalle del problema (mensaje específico sobre la causa del error).
     * @throws IOException si ocurre un error al escribir el detalle en la respuesta.
     */
    public static void writeForbidden(HttpServletResponse response, HttpServletRequest request, String detail) throws IOException {
        ProblemDetail problem = ProblemDetail.forStatus(HttpStatus.FORBIDDEN);
        problem.setTitle("Forbidden");
        problem.setDetail(detail);
        problem.setType(URI.create("urn:problem-type:forbidden"));
        problem.setInstance(URI.create(request.getRequestURI()));

        response.setStatus(HttpServletResponse.SC_FORBIDDEN);
        response.setContentType("application/problem+json");
        objectMapper.writeValue(response.getWriter(), problem);
    }

}
