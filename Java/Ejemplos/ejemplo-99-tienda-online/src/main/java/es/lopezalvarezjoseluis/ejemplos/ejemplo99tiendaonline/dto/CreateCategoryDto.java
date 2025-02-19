package es.lopezalvarezjoseluis.ejemplos.ejemplo99tiendaonline.dto;

import jakarta.persistence.Column;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class CreateCategoryDto {
    private String name;
    private String description;
}
