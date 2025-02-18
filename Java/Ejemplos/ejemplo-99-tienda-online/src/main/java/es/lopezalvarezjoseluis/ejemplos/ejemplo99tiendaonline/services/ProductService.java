package es.lopezalvarezjoseluis.ejemplos.ejemplo99tiendaonline.services;

import es.lopezalvarezjoseluis.ejemplos.ejemplo99tiendaonline.entities.Product;

import java.util.List;

public interface ProductService {
    List<Product> findAll();

    List<Product> findAllByCategoryId(Long categoryId);
}
