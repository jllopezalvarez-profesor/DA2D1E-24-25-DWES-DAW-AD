package es.lopezalvarezjoseluis.ejemplos.ejemplo99tiendaonline.repositories;

import es.lopezalvarezjoseluis.ejemplos.ejemplo99tiendaonline.entities.Product;
import org.springframework.data.domain.Limit;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {

    List<Product> findByCategoriesCategoryId(Long categoriesCategoryId, Sort sort);

}
