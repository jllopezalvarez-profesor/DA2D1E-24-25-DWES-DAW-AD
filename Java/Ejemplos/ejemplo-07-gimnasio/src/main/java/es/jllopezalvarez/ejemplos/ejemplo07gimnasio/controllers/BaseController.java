package es.jllopezalvarez.ejemplos.ejemplo07gimnasio.controllers;

import es.jllopezalvarez.ejemplos.ejemplo07gimnasio.services.CommonService;
import es.jllopezalvarez.ejemplos.ejemplo07gimnasio.services.CommonServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;

@Controller
public class BaseController {

    private final CommonService commonService;

    public BaseController(CommonService commonService) {
        this.commonService = commonService;
    }

    @ModelAttribute(name="elementoComunATodosLosControladores")
    public String addCommonTextAttribute() {
        return commonService.getTextoComun();
    }

}
