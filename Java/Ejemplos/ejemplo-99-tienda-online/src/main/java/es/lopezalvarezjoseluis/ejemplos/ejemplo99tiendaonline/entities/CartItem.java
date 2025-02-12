package es.lopezalvarezjoseluis.ejemplos.ejemplo99tiendaonline.entities;


import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
public class ShoppingCartItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long ShoppingCartItemId;
    // TODO: De momento se pone un índice único para que no pueda repetirse el producto en el carro.
    @ManyToOne
    @JoinColumn(name = "product_id", nullable = false, unique = true)
    private Product product;
    @Column(nullable = false)
    private int quantity;

    @Column(nullable = false, columnDefinition = "timestamp default current_timestamp on update current_timestamp", insertable = false, updatable = false)
    private LocalDateTime createdAt;
    @Column(nullable = false, columnDefinition = "timestamp default current_timestamp on update current_timestamp", insertable = false, updatable = false)
    private LocalDateTime updatedAt;

}
