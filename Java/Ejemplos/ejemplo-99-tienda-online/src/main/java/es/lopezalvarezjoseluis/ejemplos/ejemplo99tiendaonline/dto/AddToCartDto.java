package es.lopezalvarezjoseluis.ejemplos.ejemplo99tiendaonline.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class AddToCartDto {
    private Long productId;
    private Integer quantity;
}
