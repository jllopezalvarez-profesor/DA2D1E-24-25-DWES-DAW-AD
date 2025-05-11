package es.jllopezalvarez.ejemplos.springbootbasics.controllers.cookies;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@Controller
@RequestMapping("/cookies")
public class CookieController {
    @GetMapping("/set-cookie")
    public String setCookieForm() {
        return "cookies/set-cookie-form";
    }

    @PostMapping("/set-cookie")
    public String setCookieFormPost(@RequestParam String cookieName, @RequestParam String cookieValue, Model model, HttpServletResponse httpServletResponse) {
        if (cookieName != null && !cookieName.isBlank()) {
            if (cookieValue != null && !cookieValue.isBlank()) {
                // Fijar la cookie
                Cookie cookie = new Cookie(cookieName, cookieValue);
                cookie.setPath("/"); // Asegurar que se aplique a toda la aplicación
                httpServletResponse.addCookie(cookie); // Enviar cookie al cliente
            } else {
                // Borrar la cookie. Para borrar se sobrescribe vacía con caducidad inmediata.
                Cookie cookie = new Cookie(cookieName, ""); // Mismo nombre, valor vacío
                cookie.setPath("/"); // Asegurar que se aplique a toda la aplicación
                cookie.setMaxAge(0); // Expirarla en el momento
                httpServletResponse.addCookie(cookie); // Enviar cookie al cliente
            }
        }
        model.addAttribute("cookieName", cookieName);
        model.addAttribute("cookieValue", cookieValue);
        return "cookies/set-cookie-form";
    }

    @GetMapping("/get-cookie-value")
    // Se recupera el valor de la cookie automáticamente, y si no existe tiene el valor por defecto.
    public String getCookieValueFormPost(@CookieValue(value = "test-cookie", defaultValue = "Cookie 'test-cookie' no establecida") String cookieValue, Model model) {
        // Añadir al modelo para mostrar en vista.
        model.addAttribute("cookieValue", cookieValue);
        return "cookies/get-cookie-value";
    }

    @GetMapping("/get-all-cookies")
    public String getAllCookies(HttpServletRequest request, Model model) {
        // Obtener cookies. Si no hay cookies devuelve null, no un array vacío.
        Cookie[] cookies = request.getCookies();

        if (cookies == null) {
            // Si no hay cookies, se devuelve colección vacía.
            model.addAttribute("cookies", Collections.emptyList());
        } else {
            // Si hay, se crea un mapa para cada cookie.
            // Esto se hace porque puede haber dos cookies con el mismo nombre (pero distinto path).
            // Si se usara un diccionario para todas las cookies, no veríamos algunos valores.
            List<Map<String, String>> cookieList = new ArrayList<>();
            // Recorrer las coookies y crear un diccionario para cada una.
            for (Cookie cookie : cookies) {
                Map<String, String> cookieData = new HashMap<>();
                cookieData.put("name", cookie.getName());
                cookieData.put("value", cookie.getValue());
                cookieList.add(cookieData);
            }
            model.addAttribute("cookies", cookieList);
        }

        return "cookies/get-all-cookies";
    }


}
