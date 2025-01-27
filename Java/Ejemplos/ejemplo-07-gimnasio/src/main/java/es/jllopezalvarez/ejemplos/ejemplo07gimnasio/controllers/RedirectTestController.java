package es.jllopezalvarez.ejemplos.ejemplo07gimnasio.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/redirect-test")
public class RedirectTestController {

    @GetMapping
    public String redirectFromClassList(){
        return "redirect:/classes";
    }

    public String redirectFromTeacherList(){
        return "redirect:/teachers";
    }

}
