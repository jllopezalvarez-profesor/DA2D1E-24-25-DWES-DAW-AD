package es.lopezalvarezjoseluis.ejemplos.ejemplo08primerserviciorest.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/products")
public class ProductNormalController {

    @GetMapping("/test01")
    public String testMethod01(){
        return "Esto es el test en el controlador REST";
    }
}
