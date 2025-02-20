package es.lopezalvarezjoseluis.ejemplos.ejemplo99tiendaonline.controllers;

import es.lopezalvarezjoseluis.ejemplos.ejemplo99tiendaonline.services.CartItemServiceImpl;
import es.lopezalvarezjoseluis.ejemplos.ejemplo99tiendaonline.services.CategoryService;
import es.lopezalvarezjoseluis.ejemplos.ejemplo99tiendaonline.services.ProductService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/")
public class HomeController extends BaseController {



    public HomeController(CategoryService categoryService, CartItemServiceImpl cartItemService) {
        super(categoryService, cartItemService);
    }

    @GetMapping({"", "/"})
    public String index() {
        //return "redirect:/products";
        return "forward:/products";
    }
}
