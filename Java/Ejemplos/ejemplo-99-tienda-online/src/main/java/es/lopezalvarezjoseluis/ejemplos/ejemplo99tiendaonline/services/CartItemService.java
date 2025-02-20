package es.lopezalvarezjoseluis.ejemplos.ejemplo99tiendaonline.services;

import es.lopezalvarezjoseluis.ejemplos.ejemplo99tiendaonline.entities.CartItem;

import java.util.List;
import java.util.Optional;

public interface CartItemService {
    Optional<CartItem> findById(Long cartItemId);
    List<CartItem> findAll();

    List<CartItem> addProduct(Long productId, Integer quantity);

    Integer getQuantitySum();
}
