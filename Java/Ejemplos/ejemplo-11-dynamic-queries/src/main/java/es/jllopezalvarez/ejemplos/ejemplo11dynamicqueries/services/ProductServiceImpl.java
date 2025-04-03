package es.jllopezalvarez.ejemplos.ejemplo11dynamicqueries.services;

import es.jllopezalvarez.ejemplos.ejemplo11dynamicqueries.criteriaapi.OtherProductSpecification;
import es.jllopezalvarez.ejemplos.ejemplo11dynamicqueries.criteriaapi.ProductSpecification;
import es.jllopezalvarez.ejemplos.ejemplo11dynamicqueries.entities.Product;
import es.jllopezalvarez.ejemplos.ejemplo11dynamicqueries.repositories.ProductRepository;
import org.springframework.data.domain.*;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository;

    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public Page<Product> findWithQbe(String searchText, Long brandId, Long categoryId,
                                     String sortBy, String sortDirection, int pageNumber, int pageSize) {
        return this.findWithQbeInternal(searchText, brandId, categoryId, sortBy, sortDirection, pageNumber, pageSize, false);
    }

    @Override
    public Page<Product> findWithQbeLike(String searchText, Long brandId, Long categoryId,
                                         String sortBy, String sortDirection, int pageNumber, int pageSize) {
        return this.findWithQbeInternal(searchText, brandId, categoryId, sortBy, sortDirection, pageNumber, pageSize, true);

    }

    public Page<Product> findWithQbeInternal(String searchText, Long brandId, Long categoryId,
                                             String sortBy, String sortDirection, int pageNumber, int pageSize, boolean useLike) {

        // Configurar el orden
        Sort.Direction direction = sortDirection.equals("asc") ? Sort.Direction.ASC : Sort.Direction.DESC;
        Sort sort = Sort.by(direction, sortBy);

        // Configurar la paginación. En este ejemplo se supone que la primera página es la cero.
        Pageable pageRequest = PageRequest.of(pageNumber, pageSize, sort);

        // Crear producto vacío
        Product product = new Product();

        // Si hay cadena de búsqueda, fijar el valor en el nombre del producto.
        if (searchText != null && !searchText.isBlank()) {
            // Buscamos en nombre
            product.setName(searchText);
            // Si buscamos en dos campos QBE hace un "AND", y eso hará que no encontremos
            // cosas que sí se encuentran cuando se busca con un solo campo.
            // product.setDescription(searchText);
        }

        // Si se busca por marca, fijar el atributo de ID de marca en el objeto marca relacionado con el producto.
        // Si en el constructor del producto no se crea la marca, podría lanzar NullPointerException
        if (brandId != null) {
            product.getBrand().setId(brandId);
        }

        // Si se busca por categoría, habría que hacer algo aquí.
        // El problema es que QBE no funciona con relaciones "ToMany". Ni OneToMany, ni ManyToMany.
        if (categoryId != null) {
            // No se hace nada porque QBE no funciona en estas relaciones.
        }

        // Se crea un "ejemplo" de la entidad que buscamos.
        Example<Product> productExample = Example.of(product);

        // Si se quiere usar "like", hay que cambiar el ejemplo, usando un "ExampleMatcher"
        if (useLike) {
            // Creamos el matcher
            ExampleMatcher matcher = ExampleMatcher.matching()
                    // Esto aplica a TODAS las comparaciones de String
                    .withStringMatcher(ExampleMatcher.StringMatcher.CONTAINING)
                    // Esto sería sólo para una propiedad
                    // .withMatcher("name", ExampleMatcher.GenericPropertyMatchers.contains())
                    .withIgnoreCase(true);
            // Cambiamos el ejemplo
            productExample = Example.of(product, matcher);
        }

        // Usamos el método predefinido del repositorio para usar Query By Example.
        return productRepository.findAll(productExample, pageRequest);
    }

    @Override
    public Page<Product> findWithCriteriaApi(String search, Long brandId, Long categoryId, String sortBy, String sortDirection, Integer pageNumber, Integer pageSize) {

        // Configurar el orden
        Sort.Direction direction = sortDirection.equals("asc") ? Sort.Direction.ASC : Sort.Direction.DESC;
        Sort sort = Sort.by(direction, sortBy);

        // Configurar la paginación. En este ejemplo se supone que la primera página es la cero.
        Pageable pageRequest = PageRequest.of(pageNumber, pageSize, sort);

        // Creamos la especificación (que incluye el predicado a aplicar para las búsquedas)
      //  Specification<Product> productSpecification = ProductSpecification.findProductsForApp(search, brandId, categoryId);

        // En lugar de definirlo en una clase, se puede definir como una lambda
//        Specification<Product> productSpecification1 = Specification.where((root, query, criteriaBuilder) ->
//        {
//
//
//        })


        // Ejecutamos la consulta y devolvemos resultados
        Specification<Product> productSpecification = Specification.where((root, query, criteriaBuilder) ->
                {
                    return  criteriaBuilder.conjunction();

                }

                );

        OtherProductSpecification otherProductSpecification = new OtherProductSpecification(search, brandId, categoryId);


        return productRepository.findAll(otherProductSpecification, pageRequest);
    }
}
