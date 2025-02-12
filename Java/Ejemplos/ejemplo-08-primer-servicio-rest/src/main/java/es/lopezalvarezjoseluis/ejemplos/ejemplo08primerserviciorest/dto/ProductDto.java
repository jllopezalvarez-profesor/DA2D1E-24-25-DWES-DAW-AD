package es.lopezalvarezjoseluis.ejemplos.ejemplo08primerserviciorest.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProductDto {
    private Long productId;
    private String name;
    private String description;
    private Double price;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;


    public ProductDto(long l, String s, String s1, double v) {
        this.productId = l;
        this.name = s;
        this.description = s;
        this.price = v;
        this.createdAt = LocalDateTime.now();
        this.updatedAt = LocalDateTime.now();

    }
}
