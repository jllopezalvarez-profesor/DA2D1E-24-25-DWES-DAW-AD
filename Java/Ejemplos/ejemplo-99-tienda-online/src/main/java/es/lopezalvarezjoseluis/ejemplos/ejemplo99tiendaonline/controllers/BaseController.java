package es.lopezalvarezjoseluis.ejemplos.ejemplo99tiendaonline.controllers;

import es.lopezalvarezjoseluis.ejemplos.ejemplo99tiendaonline.entities.Category;
import es.lopezalvarezjoseluis.ejemplos.ejemplo99tiendaonline.services.CategoryService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.util.List;

public class BaseController {
    private final CategoryService categoryService;

    public BaseController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @ModelAttribute("categories")
    List<Category> getAllCategories(){
        return categoryService.findAll();
    }

    @ModelAttribute("cartItemsCount")
    int getCartItemsCount(){
        return 10;
    }

    protected CategoryService getCategoryService() {
        return categoryService;
    }

}
