package es.lopezalvarezjoseluis.ejemplos.ejemplo99tiendaonline.controllers;

import es.lopezalvarezjoseluis.ejemplos.ejemplo99tiendaonline.dto.CartDto;
import es.lopezalvarezjoseluis.ejemplos.ejemplo99tiendaonline.entities.Category;
import es.lopezalvarezjoseluis.ejemplos.ejemplo99tiendaonline.services.CartItemService;
import es.lopezalvarezjoseluis.ejemplos.ejemplo99tiendaonline.services.CartItemServiceImpl;
import es.lopezalvarezjoseluis.ejemplos.ejemplo99tiendaonline.services.CategoryService;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.util.List;

public class BaseController {
    private final CategoryService categoryService;
    private final CartItemService cartItemService;

    public BaseController(CategoryService categoryService, CartItemService cartItemService) {
        this.categoryService = categoryService;
        this.cartItemService = cartItemService;
    }

    @ModelAttribute("categories")
    List<Category> getAllCategories(){
        return categoryService.findAll();
    }

    @ModelAttribute("cart")
    CartDto getCart(){
        return new CartDto(cartItemService.findAll());
    }

    protected CategoryService getCategoryService() {
        return categoryService;
    }

    protected CartItemService getCartItemService() {
        return cartItemService;
    }

}
