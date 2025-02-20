package es.lopezalvarezjoseluis.ejemplos.ejemplo99tiendaonline.services;

import es.lopezalvarezjoseluis.ejemplos.ejemplo99tiendaonline.entities.Category;

import java.util.List;
import java.util.Optional;

public interface CategoryService {
    List<Category> findAll();

    Optional<Category> findById(Long categoryId);

    void create(String name, String description);
}
