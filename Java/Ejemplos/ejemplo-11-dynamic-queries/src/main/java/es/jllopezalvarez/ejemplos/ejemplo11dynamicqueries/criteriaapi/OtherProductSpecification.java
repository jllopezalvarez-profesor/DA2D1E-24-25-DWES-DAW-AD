package es.jllopezalvarez.ejemplos.ejemplo11dynamicqueries.criteriaapi;

import es.jllopezalvarez.ejemplos.ejemplo11dynamicqueries.entities.Brand;
import es.jllopezalvarez.ejemplos.ejemplo11dynamicqueries.entities.Category;
import es.jllopezalvarez.ejemplos.ejemplo11dynamicqueries.entities.Product;
import jakarta.persistence.criteria.*;
import org.springframework.data.jpa.domain.Specification;


public class OtherProductSpecification implements Specification<Product> {


    private final String search;
    private final Long brandId;
    private final Long categoryId;

    public OtherProductSpecification(String search, Long brandId, Long categoryId) {
        this.search = search;
        this.brandId = brandId;
        this.categoryId = categoryId;
    }

    @Override
    public Predicate toPredicate(Root<Product> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
        // Implementación del método "toPredicate" de "Specification"
        // Este método crea un predicado (algo que devuelve true/false) combinando distintos criterios.
        // Parámetros:
        // - root: Representa la entidad principal de la consulta (en este caso, Product).
        //         Se utiliza para acceder a los atributos de la entidad y realizar operaciones como root.get("name").
        // - query: Objeto que representa la consulta completa. Permite modificar aspectos adicionales de la consulta,
        //          como el ordenamiento (orderBy), la selección de columnas (select), y evitar duplicados (distinct).
        // - criteriaBuilder: Es el constructor de la consulta. Se utiliza para crear predicados (Predicate),
        //                    como condiciones de filtro (equal, like), y combinarlos mediante operaciones lógicas (and, or).
        // Predicado (algo que devuelve true / false) para acumular varios criterios
        // .conjunction() crea un predicado que siempre es "true" (1=1), para poder combinarlo con otros predicados con "and"
        // .disjunction() crea un predicado que siempre es "false" (1<>1), para poder combinarlo con otros predicados con "or"
        Predicate finalPredicate = criteriaBuilder.conjunction();

        // where 1=1

        // Si se busca texto, se hace en nombre y descripción
        if (search != null && !search.isBlank()) {
            // Crear un predicado para un "OR" entre nombre y descripción
            Predicate nameOrDescritionPredicate = criteriaBuilder.or(
                    criteriaBuilder.like(root.get("name"), String.format("%%%s%%", search)),
                    criteriaBuilder.like(root.get("description"), String.format("%%%s%%", search)));

            // Añadirlo como "AND" al predicado existente
            finalPredicate = criteriaBuilder.and(finalPredicate, nameOrDescritionPredicate);
        }

        // where 1<>1 or (name = p and desc=x) or (name=q and fee=334) -- disjunction

        // where 1=1 and (name like '%xxx%' or description like '%xxx%')

        // Si se busca id de marca, se crea el predicado y añade como "AND" al predicado existente
        if (brandId != null) {
            // Como es una relación hay que hacer un JOIN entre entidades
            Join<Product, Brand> productBrandJoin = root.join("brand", JoinType.INNER); // Puede hacerse outer join

            // Crear el predicado para buscar por el id de la marca
            Predicate brandPredicate = criteriaBuilder.equal(productBrandJoin.get("id"), brandId);

            // Añadirlo como "AND" al predicado final
            finalPredicate = criteriaBuilder.and(finalPredicate, brandPredicate);
        }

        // inner join brand on product.brand_id = brand.id
        // where 1=1 and (name like '%xxx%' or description like '%xxx%') and brand.id=nnn

        // Si se busca id de categoría, se crea el predicado y añade como "AND" al predicado existente
        if (categoryId != null) {
            // Como es una relación hay que hacer un JOIN entre entidades
            Join<Product, Category> productCategoryJoin = root.join("categories", JoinType.INNER); // La relación ManyToMany se llama "categories"

            // Crear el predicado para buscar por el id de la categoría
            Predicate categoryPredicate = criteriaBuilder.equal(productCategoryJoin.get("id"), categoryId);

            // Añadirlo como "AND" al predicado final
            finalPredicate = criteriaBuilder.and(finalPredicate, categoryPredicate);
        }

        // inner join brand on product.brand_id = brand.id
        // inner join product_category on product.id = product_category.product_id
        // inner join category on product_category.category_id = category.id
        // where 1=1 and (name like '%xxx%' or description like '%xxx%') and (brand.id=nnn)
        // and (category.id=zzz)

        // Se devuelve el predicado creado
        return finalPredicate;
    }

}