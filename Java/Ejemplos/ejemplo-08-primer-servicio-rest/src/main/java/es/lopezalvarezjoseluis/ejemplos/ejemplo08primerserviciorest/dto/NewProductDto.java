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
public class NewProductDto {
    private String name;
    private String description;
    private Double price;
}
