package es.lopezalvarezjoseluis.ejemplos.ejemplo99tiendaonline.restcontrollers;

import es.lopezalvarezjoseluis.ejemplos.ejemplo99tiendaonline.dto.AddToCartDto;
import es.lopezalvarezjoseluis.ejemplos.ejemplo99tiendaonline.dto.CartDto;
import es.lopezalvarezjoseluis.ejemplos.ejemplo99tiendaonline.services.CartItemService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/cart")
public class CartRestController {

    private final CartItemService cartItemService;

    public CartRestController(CartItemService cartItemService) {
        this.cartItemService = cartItemService;
    }

    @PostMapping
    ResponseEntity<CartDto> addToCart(@RequestBody AddToCartDto addToCartDto) {
        return ResponseEntity.ok(new CartDto(cartItemService.addProduct(addToCartDto.getProductId(), addToCartDto.getQuantity())));
    }

}
