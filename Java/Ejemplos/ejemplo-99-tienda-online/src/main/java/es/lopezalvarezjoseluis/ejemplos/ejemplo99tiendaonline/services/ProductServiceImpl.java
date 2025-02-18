package es.lopezalvarezjoseluis.ejemplos.ejemplo99tiendaonline.services;

import es.lopezalvarezjoseluis.ejemplos.ejemplo99tiendaonline.entities.Product;
import es.lopezalvarezjoseluis.ejemplos.ejemplo99tiendaonline.repositories.ProductRepository;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository;

    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public List<Product> findAll(){
        return productRepository.findAll(Sort.by(Sort.Direction.ASC, "name"));
    }

    @Override
    public List<Product> findAllByCategoryId(Long categoryId){
        return productRepository.findByCategoriesCategoryId(categoryId, Sort.by(Sort.Direction.ASC, "name"));
    }

}
