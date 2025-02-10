package es.lopezalvarezjoseluis.ejemplos.ejemplo08primerserviciorest.controllers;

import es.lopezalvarezjoseluis.ejemplos.ejemplo08primerserviciorest.dto.ProductDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    private final Map<Long, ProductDto> products;

    public ProductController() {
        products = new HashMap<>(Map.of(
                1L, new ProductDto(1L, "Producto 1", "Desc. producto 1", 100D),
                2L, new ProductDto(2L, "Producto 2", "Desc. producto 2", 100D),
                3L, new ProductDto(3L, "Producto 3", "Desc. producto 3", 100D)));
    }

    @GetMapping("/test01")
    public String testMethod01() {
        return "Esto es el test en el controlador REST";
    }

//    @GetMapping("/{productId}")
//    public ProductDto getProductByIdSinCodigosHttp(@PathVariable("productId") Long productId) {
//        return products.get(productId);
//    }

    @GetMapping("/{productId}")
    public ResponseEntity<ProductDto> getProductById(@PathVariable("productId") Long productId) {
        if (products.containsKey(productId)) {
            return ResponseEntity.ok(products.get(productId));
        }
        return ResponseEntity.notFound().build();

        // Aun no podemos esto, lo haremos con errores que se gestioarán adecuadamente.
        // return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No se ha encontrado");
    }

    @GetMapping
    public ResponseEntity<Iterable<ProductDto>> getAllProducts() {
        return ResponseEntity.ok(products.values());
    }

    @DeleteMapping("/{productId}")
    public ResponseEntity<ProductDto> deleteProductById(@PathVariable("productId") Long productId) {
        if (products.containsKey(productId)) {
            return ResponseEntity.ok(products.remove(productId));
        }
        return ResponseEntity.notFound().build();

        // Aun no podemos esto, lo haremos con errores que se gestioarán adecuadamente.
        // return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No se ha encontrado");
    }


}
