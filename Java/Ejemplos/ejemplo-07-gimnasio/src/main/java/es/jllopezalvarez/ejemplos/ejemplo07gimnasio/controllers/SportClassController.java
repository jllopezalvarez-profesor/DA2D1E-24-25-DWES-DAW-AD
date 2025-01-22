package es.jllopezalvarez.ejemplos.ejemplo07gimnasio.controllers;

import es.jllopezalvarez.ejemplos.ejemplo07gimnasio.entities.SportClass;
import es.jllopezalvarez.ejemplos.ejemplo07gimnasio.services.CommonService;
import es.jllopezalvarez.ejemplos.ejemplo07gimnasio.services.SportClassService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/classes")
public class SportClassController extends BaseController {

    private final SportClassService sportClassService;

    public SportClassController(SportClassService sportClassService, CommonService commonService) {
        super(commonService);
        this.sportClassService = sportClassService;
    }


    @GetMapping({"", "/"})
    public ModelAndView index(Model model) {
        ModelAndView modelAndView = new ModelAndView("classes/index");
        List<SportClass> classes = sportClassService.findAll();

        modelAndView.addObject("classes", classes);

        return modelAndView;
    }

}
