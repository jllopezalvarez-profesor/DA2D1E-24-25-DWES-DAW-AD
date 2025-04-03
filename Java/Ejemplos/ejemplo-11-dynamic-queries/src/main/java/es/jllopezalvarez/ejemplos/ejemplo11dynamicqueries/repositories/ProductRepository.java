package es.jllopezalvarez.ejemplos.ejemplo11dynamicqueries.repositories;

import es.jllopezalvarez.ejemplos.ejemplo11dynamicqueries.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

// Además de extender JpaRepository, se extiende JpaSpecificationExecutor, para poder ejecutar consultas con Criteria API
public interface ProductRepository extends JpaRepository<Product, Long>, JpaSpecificationExecutor<Product> {
}
