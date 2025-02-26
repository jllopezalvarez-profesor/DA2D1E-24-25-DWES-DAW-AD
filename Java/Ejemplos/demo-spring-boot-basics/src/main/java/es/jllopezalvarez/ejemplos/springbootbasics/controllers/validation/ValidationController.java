package es.jllopezalvarez.ejemplos.springbootbasics.controllers.validation;

import es.jllopezalvarez.ejemplos.springbootbasics.PersonService;
import es.jllopezalvarez.ejemplos.springbootbasics.dto.validation.NewPersonFormDto;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
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
        NewPersonFormDto newPersonFormDto = new NewPersonFormDto();
        return new ModelAndView("validation/new-person", "person", newPersonFormDto);
    }

    @PostMapping("/new/person")
    public String newPersonPost(@Valid @ModelAttribute NewPersonFormDto newPersonFormDto,
                                BindingResult bindingResult, Model model) {
        System.out.println(newPersonFormDto);
        if (bindingResult.hasErrors()) {
            model.addAttribute("person", newPersonFormDto);
            return "validation/new-person";
        }
        personService.create(newPersonFormDto);
        return "validation/new-person-ok";
    }


}
