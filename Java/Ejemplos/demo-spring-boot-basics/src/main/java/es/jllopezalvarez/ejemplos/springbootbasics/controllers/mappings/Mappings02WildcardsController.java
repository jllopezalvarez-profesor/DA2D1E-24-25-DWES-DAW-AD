package es.jllopezalvarez.ejemplos.springbootbasics.controllers.mappings;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * Este controlador muestra cómo se pueden crear rutas mas "relajadas",
 * que pueden admitir una amplia gama de valores en algunos sitios
 */
@Controller
@RequestMapping("/mappings-02-wildcards") // URL "base" del controlador
public class Mappings02WildcardsController {

    // Método para URL básica
    @GetMapping({"", "/"})
    public ModelAndView index() {
        ModelAndView modelAndView = new ModelAndView("mappings/mappings-02-wildcards");
        modelAndView.addObject("variable", "Nada");
        modelAndView.addObject("controller", this.getClass().getSimpleName());
        modelAndView.addObject("method", Thread.currentThread().getStackTrace()[1].getMethodName());
        return modelAndView;
    }

    // Método para URL con un segmento que puede contener lo que sea
    @GetMapping("/primero/*/tercero/{var}")
    public ModelAndView unWildcardCentro(@PathVariable("var") String variable) {
        ModelAndView modelAndView = new ModelAndView("mappings/mappings-02-wildcards");
        modelAndView.addObject("variable", variable);
        modelAndView.addObject("controller", this.getClass().getSimpleName());
        modelAndView.addObject("method", Thread.currentThread().getStackTrace()[1].getMethodName());
        return modelAndView;
    }

    // Método para URL con un varios segmentos que pueden contener
    // lo que sea, y que están en el centro de la URL
    // Esto no funciona. Falla al ejecutar porque después de ** no se pueden poner más cosas.
    // Para probarlo, descomentar el método.
//    @GetMapping("/primero/**/tercero/{var}")
//    public ModelAndView variosWildcardCentro(@PathVariable("var") String variable) {
//        ModelAndView modelAndView = new ModelAndView("mappings/mappings-02-wildcards");
//        modelAndView.addObject("variable", variable);
//        modelAndView.addObject("controller", this.getClass().getSimpleName());
//        modelAndView.addObject("method", Thread.currentThread().getStackTrace()[1].getMethodName());
//        return modelAndView;
//    }



    // Método para URL con **, para que se alargue lo que se quiera a la derecha
    // Útil para añadir información en la URL que no sirve para procesar, pero si para SEO
    @GetMapping("/algo/otra-cosa/{id}/**")
    public ModelAndView variosWildcardFinal(@PathVariable("id") String variable) {
        ModelAndView modelAndView = new ModelAndView("mappings/mappings-02-wildcards");
        modelAndView.addObject("variable", variable);
        modelAndView.addObject("controller", this.getClass().getSimpleName());
        modelAndView.addObject("method", Thread.currentThread().getStackTrace()[1].getMethodName());
        return modelAndView;
    }

    // Método para URL con * en pathVariable, para que se alargue lo que se quiera a la
    // derecha, pero que se capture ese valor como variable, para procesarlo en código Java.
    @GetMapping("/algo/algo-distinto/{*pathRestante}")
    public ModelAndView variosWildcardFinalEnVariable(@PathVariable("pathRestante") String pathRestante) {
        ModelAndView modelAndView = new ModelAndView("mappings/mappings-02-wildcards");
        modelAndView.addObject("pathRestante", pathRestante);
        modelAndView.addObject("controller", this.getClass().getSimpleName());
        modelAndView.addObject("method", Thread.currentThread().getStackTrace()[1].getMethodName());
        return modelAndView;
    }


}
