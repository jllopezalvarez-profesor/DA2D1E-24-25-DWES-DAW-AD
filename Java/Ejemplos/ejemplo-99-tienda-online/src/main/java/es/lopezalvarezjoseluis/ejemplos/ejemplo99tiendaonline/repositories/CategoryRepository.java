package es.lopezalvarezjoseluis.ejemplos.ejemplo99tiendaonline.repositories;

import es.lopezalvarezjoseluis.ejemplos.ejemplo99tiendaonline.entities.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {
}
