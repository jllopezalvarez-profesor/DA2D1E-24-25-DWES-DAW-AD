package es.jllopezalvarez.ejemplos.springbootbasics.controllers.mappings;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.UUID;

/**
 * Este controlador muestra cómo se puede procesar una misma URL con distintos métodos usando restricciones.
 * La idea es que, en función del dato que se recibe, se usa un método u otro.
 */
@Controller
@RequestMapping("/mappings-01-restricciones") // URL "base" del controlador
public class Mappings01RestriccionesController {

    // Este método es para cuando no se pasa nada por la URL.
    @GetMapping({"", "/"})
    public ModelAndView index() {
        ModelAndView modelAndView = new ModelAndView("mappings/mappings-01-restricciones");
        modelAndView.addObject("id", "Ninguno");
        modelAndView.addObject("controller", this.getClass().getSimpleName());
        modelAndView.addObject("method", Thread.currentThread().getStackTrace()[1].getMethodName());
        return modelAndView;
    }

    // Este método sólo admite ids que sean de tipo entero o long.
    // La expresión regular "\d+", que aparece con dos barras porque
    // está escapada, significa "uno o más (+) dígitos (\d)"
    @GetMapping("/{id:\\d+}")
    public ModelAndView processIdNumerico(@PathVariable("id") Integer id) {
        ModelAndView modelAndView = new ModelAndView("mappings/mappings-01-restricciones");
        modelAndView.addObject("id", id);
        modelAndView.addObject("controller", this.getClass().getSimpleName());
        modelAndView.addObject("method", Thread.currentThread().getStackTrace()[1].getMethodName());
        return modelAndView;
    }

    // Este método sólo admite ids que sean de tipo String, formados
    // sólo por letras. La expresión regular "[a-zA-Z]+", significa
    // "una o más (+) letras minúsculas (a-z) o mayúsculas (A-Z)"
    @GetMapping("/{id:[a-zA-Z]+}")
    public ModelAndView processIdLetras(@PathVariable("id") String id) {
        ModelAndView modelAndView = new ModelAndView("mappings/mappings-01-restricciones");
        modelAndView.addObject("id", id);
        modelAndView.addObject("controller", this.getClass().getSimpleName());
        modelAndView.addObject("method", Thread.currentThread().getStackTrace()[1].getMethodName());
        return modelAndView;
    }

    // Este método sólo admite ids que sean de tipo UUID, formados
    // sólo por letras. La expresión regular representa la estructura
    // de un UUID, formado por cinco grupos de caracteres hexadecimales.
    // El primero de 8, segundo, tercero y cuarto de 4, y el último de 12.
    // Cada caracter pude ser un número de 0 a 9, o una letra mayúscula
    // o minúscula de a a F. Los grupos se separan por guiones
    @GetMapping("/{id:[0-9a-fA-F]{8}-[0-9a-fA-F]{4}-[0-9a-fA-F]{4}-[0-9a-fA-F]{4}-[0-9a-fA-F]{12}}")
    public ModelAndView processIdUuid(@PathVariable("id") UUID id) {
        ModelAndView modelAndView = new ModelAndView("mappings/mappings-01-restricciones");
        modelAndView.addObject("id", id);
        modelAndView.addObject("controller", this.getClass().getSimpleName());
        modelAndView.addObject("method", Thread.currentThread().getStackTrace()[1].getMethodName());
        return modelAndView;
    }

    // Aún habría caos sin cubrir. Por ejemplo, si el valor recibido
    // es una combinación de letras y números. Poner un método sin
    // restricciones no funciona. Podríamos pensar que Spring, si no se cumple
    // ninguno de los anteriores, se cumple este. El problema es que, en realidad,
    // un guid cumple con este patrón. Son caracteres, los que sean.
    // Spring detecta el conflicto y el mapeo no funciona.
    // Si se quitan los comentarios al método siguiente, se puede apreciar cómo falla.
//     @GetMapping("/{id}")
//     public ModelAndView processIdString(@PathVariable("id") String id) {
//         ModelAndView modelAndView = new ModelAndView("mappings/mappings-01-restricciones");
//         modelAndView.addObject("id", id);
//         modelAndView.addObject("controller", this.getClass().getSimpleName());
//         modelAndView.addObject("method", Thread.currentThread().getStackTrace()[1].getMethodName());
//         return modelAndView;
//     }


}
