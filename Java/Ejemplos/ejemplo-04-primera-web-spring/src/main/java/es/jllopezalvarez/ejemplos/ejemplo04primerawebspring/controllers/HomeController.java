package es.jllopezalvarez.ejemplos.ejemplo04primerawebspring.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

    @RequestMapping(value = {"", "/"})
    private String redirectToEvents(){
        return "redirect:/events";
    }

}
