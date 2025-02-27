package es.jllopezalvarez.ejemplos.springbootbasics.controllers.validation;

import es.jllopezalvarez.ejemplos.springbootbasics.services.PersonService;
import es.jllopezalvarez.ejemplos.springbootbasics.dto.validation.NewPersonFormDto;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/validation")
public class ValidationController {
    private final PersonService personService;

    public ValidationController(PersonService personService) {
        this.personService = personService;
    }

    @GetMapping("/new/person")
    public ModelAndView newPersonGet() {
        return new ModelAndView("validation/new-person", "person", new NewPersonFormDto());
    }

    @PostMapping("/new/person")
    public String newPersonPost(@Valid @ModelAttribute("person") NewPersonFormDto newPersonFormDto,
                                BindingResult bindingResult) {
        System.out.println(newPersonFormDto);

        if (bindingResult.hasErrors()) {
            System.out.printf("Hay %s errores de validación: \n", bindingResult.getErrorCount());
            bindingResult.getAllErrors().forEach(error -> System.out.println(error.getDefaultMessage()));
            // No es necesario añadirlo explícitamente porque con @ModelAttribute ya estamos añadiendo el objeto al modelo
            // model.addAttribute("person", newPersonFormDto);
            return "validation/new-person";
        }

        personService.create(newPersonFormDto);
        return "validation/new-person-ok";
    }


}
