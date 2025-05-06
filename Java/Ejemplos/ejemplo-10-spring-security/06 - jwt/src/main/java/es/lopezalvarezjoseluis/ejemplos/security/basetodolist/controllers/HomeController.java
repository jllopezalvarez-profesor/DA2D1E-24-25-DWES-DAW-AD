package es.lopezalvarezjoseluis.ejemplos.security.basetodolist.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HomeController {

    @GetMapping({"","/"} )
    public String home() {
        return "home";
    }

    @PostMapping({"","/"} )
    public String postHome(@RequestParam("texto") String texto) {
        System.out.println("Se ha recibido el texto: " + texto);
        return "home";
    }

    @GetMapping("/login-personalizado")
    public String login() {
        return "login-personalizado";
    }

}
