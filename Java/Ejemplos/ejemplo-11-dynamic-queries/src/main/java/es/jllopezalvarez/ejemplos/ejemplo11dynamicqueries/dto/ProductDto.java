package es.jllopezalvarez.ejemplos.ejemplo11dynamicqueries.dto;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class ProductDto {
    private Long id;
    private String name;
    private String description;
    private BigDecimal price;
    private int stock;
    private boolean available;
    private String brandName;
    private List<String> categoryNames = new ArrayList<>();
}
