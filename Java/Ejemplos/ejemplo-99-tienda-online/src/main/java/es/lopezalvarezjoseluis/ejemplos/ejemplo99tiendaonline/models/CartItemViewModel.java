package es.lopezalvarezjoseluis.ejemplos.ejemplo99tiendaonline.models;

import es.lopezalvarezjoseluis.ejemplos.ejemplo99tiendaonline.entities.CartItem;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CartItemViewModel {
    private Long cartItemId;
    private String productName;
    private int quantity;
    private Double unitPrice;

    public CartItemViewModel(CartItem cartItem) {
        this.cartItemId = cartItem.getCartItemId();
        this.productName = cartItem.getProduct().getName();
        this.quantity = cartItem.getQuantity();
        this.unitPrice = cartItem.getProduct().getPrice();
    }

    private Double getTotalPrice(){
        return this.quantity * this.unitPrice;
    }
}
