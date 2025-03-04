package es.lopezalvarezjoseluis.ejemplos.ejemplo99tiendaonline.controllers;

import es.lopezalvarezjoseluis.ejemplos.ejemplo99tiendaonline.dto.CreateCategoryDto;
import es.lopezalvarezjoseluis.ejemplos.ejemplo99tiendaonline.services.CategoryService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/categories")
public class CategoryController {

    private final CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

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
        categoryService.create(categoryDto.getName(), categoryDto.getDescription());
        return new ModelAndView("admin/categories/new", "category", categoryDto);
    }


}
