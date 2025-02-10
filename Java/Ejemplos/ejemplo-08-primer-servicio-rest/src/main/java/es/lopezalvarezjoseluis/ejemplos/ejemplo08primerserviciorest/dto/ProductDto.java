package es.lopezalvarezjoseluis.ejemplos.ejemplo08primerserviciorest.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProductDto {
    private Long productId;
    private String name;
    private String description;
    private Double price;
}
