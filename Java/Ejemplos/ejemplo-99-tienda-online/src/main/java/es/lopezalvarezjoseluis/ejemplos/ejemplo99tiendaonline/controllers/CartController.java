package es.lopezalvarezjoseluis.ejemplos.ejemplo99tiendaonline.controllers;

import es.lopezalvarezjoseluis.ejemplos.ejemplo99tiendaonline.entities.CartItem;
import es.lopezalvarezjoseluis.ejemplos.ejemplo99tiendaonline.dto.CartDto;
import es.lopezalvarezjoseluis.ejemplos.ejemplo99tiendaonline.services.CartItemService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;


@Controller
@RequestMapping("/cart")
public class CartController {

    private final CartItemService cartItemService;

    public CartController(CartItemService cartItemService) {
        this.cartItemService = cartItemService;
    }

    @GetMapping({"", "/"})
    public ModelAndView cart() {
        ModelAndView modelAndView = new ModelAndView("cart");
        List<CartItem> cartItems = cartItemService.findAll();
        modelAndView.addObject("cartItems", new CartDto(cartItems));
        return modelAndView;
    }





}
