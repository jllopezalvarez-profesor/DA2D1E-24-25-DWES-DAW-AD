package es.jllopezalvarez.ejemplos.ejemplo11dynamicqueries.services;

import es.jllopezalvarez.ejemplos.ejemplo11dynamicqueries.entities.Product;
import org.springframework.data.domain.Page;

public interface ProductService {

    Page<Product> findWithQbe(String searchText, Long brandId, Long categoryId, String sortBy, String sortDirection, int pageNumber, int pageSize);

    Page<Product> findWithQbeLike(String searchText, Long brandId, Long categoryId, String sortBy, String sortDirection, int pageNumber, int pageSize);

    Page<Product> findWithCriteriaApi(String search, Long brandId, Long categoryId, String sortBy, String sortDir, Integer pageNumber, Integer pageSize);
}
