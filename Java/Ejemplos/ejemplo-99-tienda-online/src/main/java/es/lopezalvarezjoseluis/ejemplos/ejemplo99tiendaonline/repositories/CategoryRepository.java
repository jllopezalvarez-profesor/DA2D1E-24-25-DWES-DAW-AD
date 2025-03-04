package es.lopezalvarezjoseluis.ejemplos.ejemplo99tiendaonline.repositories;

import es.lopezalvarezjoseluis.ejemplos.ejemplo99tiendaonline.entities.Category;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CategoryRepository extends JpaRepository<Category, Long> {

    boolean existsCategoryByNameIgnoreCase(String name);

//    Page<Category> findCategoryByNameContainingIgnoreCaseOrderByName(String name, Pageable pageable);
//
//    @Query(value = "select * from category where 1=3", nativeQuery = true)
//    Page<Category> miMetodo(String name, Pageable pageable);
}