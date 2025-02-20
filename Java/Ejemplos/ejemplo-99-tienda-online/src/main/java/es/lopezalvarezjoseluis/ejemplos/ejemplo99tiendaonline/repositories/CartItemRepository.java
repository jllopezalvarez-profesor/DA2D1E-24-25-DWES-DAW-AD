package es.lopezalvarezjoseluis.ejemplos.ejemplo99tiendaonline.repositories;

import es.lopezalvarezjoseluis.ejemplos.ejemplo99tiendaonline.entities.CartItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface CartItemRepository extends JpaRepository<CartItem, Long> {
    Optional<CartItem> findByProductProductId(Long productId);

    @Query("select sum(cartItem.quantity) from CartItem cartItem")
    Integer quantitySum();
}
