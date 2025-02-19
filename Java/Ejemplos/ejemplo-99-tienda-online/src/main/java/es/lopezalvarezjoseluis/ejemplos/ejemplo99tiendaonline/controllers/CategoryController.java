package es.lopezalvarezjoseluis.ejemplos.ejemplo99tiendaonline.controllers;

import es.lopezalvarezjoseluis.ejemplos.ejemplo99tiendaonline.dto.CreateCategoryDto;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/admin/categories")
public class CategoryController {

    // Muestra el formulario de crear categoría
    @GetMapping("/new")
    public ModelAndView newCategory() {
        ModelAndView modelAndView = new ModelAndView("admin/categories/new");
        modelAndView.addObject("category", new CreateCategoryDto());
        return modelAndView;
    }

    // Procesar el post del formulario
    @PostMapping("/new")
    public ModelAndView newCategory(@ModelAttribute CreateCategoryDto categoryDto) {

        System.out.println("Procesando la petición de nueva categoría");
        System.out.println(categoryDto);
        return new ModelAndView("admin/categories/new", "category", categoryDto);
    }


}
