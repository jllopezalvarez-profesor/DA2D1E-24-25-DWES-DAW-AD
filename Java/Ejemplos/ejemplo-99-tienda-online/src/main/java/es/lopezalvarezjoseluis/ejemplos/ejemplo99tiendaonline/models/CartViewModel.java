package es.lopezalvarezjoseluis.ejemplos.ejemplo99tiendaonline.models;

import es.lopezalvarezjoseluis.ejemplos.ejemplo99tiendaonline.entities.CartItem;

import java.util.ArrayList;
import java.util.List;

public class CartViewModel {
    private List<CartItemViewModel> items = new ArrayList<>();

    private Integer getProductCount() {
        return items.stream().mapToInt(CartItemViewModel::getQuantity).sum();
    }

    private Double getTotalPrice() {
        return items.stream().mapToDouble(item -> item.getUnitPrice() * item.getQuantity()).sum();
    }

    public CartViewModel(List<CartItem> cartItems){
        this.items = cartItems.stream().map(cartItem -> new CartItemViewModel(cartItem)).toList();

    }
}
