package es.jllopezalvarez.ejemplos.springbootbasics.controllers.sessions;

import es.jllopezalvarez.ejemplos.springbootbasics.dto.sessions.RegisterUserDto;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;

@Controller
@RequestMapping("/sessions/register")
@SessionAttributes("user")
public class UserRegistrationController {
    @ModelAttribute("user")
    public RegisterUserDto user() {
        return RegisterUserDto.builder().build();
    }

    // Paso 1: email
    @GetMapping("/step1")
    public String step1() {
        return "sessions/register/step1";
    }

    @PostMapping("/step1")
    public String processStep1(@ModelAttribute("user") RegisterUserDto user) {
        return "redirect:/sessions/register/step2";
    }

    // Paso 2: password y repetir
    @GetMapping("/step2")
    public String step2() {
        return "sessions/register/step2";
    }

    @PostMapping("/step2")
    public String processStep2(@ModelAttribute("user") RegisterUserDto user) {
        return "redirect:/sessions/register/step3";
    }

    // Paso 3: nombre y apellidos
    @GetMapping("/step3")
    public String step3() {
        return "sessions/register/step3";
    }

    @PostMapping("/step3")
    public String processStep3(@ModelAttribute("user") RegisterUserDto user) {
        return "redirect:/sessions/register/step4";
    }

    // Paso 4: verificación y aceptación
    @GetMapping("/step4")
    public String step4(@ModelAttribute("user") RegisterUserDto user) {
        return "sessions/register/step4";
    }

    @PostMapping("/step4")
    public String processStep4(@ModelAttribute("user") RegisterUserDto user) {
        return "redirect:/sessions/register/step5";
    }

    // Paso 5: confirmación final
    @GetMapping("/step5")
    public String step5(@ModelAttribute("user") RegisterUserDto user, SessionStatus status) {
        // Aquí se podría guardar el usuario en la base de datos
        status.setComplete(); // Limpia el atributo de sesión
        return "sessions/register/step5";
    }

}
