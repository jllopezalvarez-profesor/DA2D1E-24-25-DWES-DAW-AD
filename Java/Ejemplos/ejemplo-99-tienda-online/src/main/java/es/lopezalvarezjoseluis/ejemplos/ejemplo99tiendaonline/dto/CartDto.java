package es.lopezalvarezjoseluis.ejemplos.ejemplo99tiendaonline.dto;

import es.lopezalvarezjoseluis.ejemplos.ejemplo99tiendaonline.entities.CartItem;

import java.util.ArrayList;
import java.util.List;

public class CartDto {
    private List<CartItemDto> items = new ArrayList<>();

    public Integer getProductCount() {
        return items.stream().mapToInt(CartItemDto::getQuantity).sum();
    }

    public Double getTotalPrice() {
        return items.stream().mapToDouble(item -> item.getUnitPrice() * item.getQuantity()).sum();
    }

    public CartDto(List<CartItem> cartItems){
        this.items = cartItems.stream().map(CartItemDto::new).toList();
    }
}
