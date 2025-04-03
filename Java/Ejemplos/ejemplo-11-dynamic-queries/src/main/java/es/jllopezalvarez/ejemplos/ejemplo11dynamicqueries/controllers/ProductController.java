package es.jllopezalvarez.ejemplos.ejemplo11dynamicqueries.controllers;

import es.jllopezalvarez.ejemplos.ejemplo11dynamicqueries.dto.ProductDto;
import es.jllopezalvarez.ejemplos.ejemplo11dynamicqueries.entities.Product;
import es.jllopezalvarez.ejemplos.ejemplo11dynamicqueries.services.ProductService;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.web.PagedModel;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/products")
public class ProductController {
    private final ProductService productService;
    private final ModelMapper modelMapper;

    public ProductController(ProductService productService, ModelMapper modelMapper) {
        this.productService = productService;
        this.modelMapper = modelMapper;
    }

    @GetMapping("/find-qbe")
    public ResponseEntity<PagedModel<ProductDto>> findWithQbe(@RequestParam(required = false) String search,
                                                              @RequestParam(required = false) Long brandId,
                                                              @RequestParam(required = false) Long categoryId,
                                                              @RequestParam(defaultValue = "name") String sortBy,
                                                              @RequestParam(defaultValue = "asc") String sortDir,
                                                              @RequestParam(defaultValue = "0") Integer pageNumber,
                                                              @RequestParam(defaultValue = "10") Integer pageSize) {

        Page<Product> productPage = productService.findWithQbe(search, brandId, categoryId, sortBy, sortDir, pageNumber, pageSize);
        Page<ProductDto> productDtoPage = productPage.map(product -> modelMapper.map(product, ProductDto.class));
        return ResponseEntity.ok(new PagedModel<>(productDtoPage));
    }

    @GetMapping("/find-qbe-like")
    public ResponseEntity<PagedModel<ProductDto>> findWithQbeLike(@RequestParam(required = false) String search,
                                                                  @RequestParam(required = false) Long brandId,
                                                                  @RequestParam(required = false) Long categoryId,
                                                                  @RequestParam(defaultValue = "name") String sortBy,
                                                                  @RequestParam(defaultValue = "asc") String sortDir,
                                                                  @RequestParam(defaultValue = "0") Integer pageNumber,
                                                                  @RequestParam(defaultValue = "10") Integer pageSize) {

        Page<Product> productPage = productService.findWithQbeLike(search, brandId, categoryId, sortBy, sortDir, pageNumber, pageSize);
        Page<ProductDto> productDtoPage = productPage.map(product -> modelMapper.map(product, ProductDto.class));
        return ResponseEntity.ok(new PagedModel<>(productDtoPage));
    }

    @GetMapping("find-criteria-query")
    public ResponseEntity<PagedModel<ProductDto>> findWithCriteriaQuery(@RequestParam(required = false) String search,
                                                                        @RequestParam(required = false) Long brandId,
                                                                        @RequestParam(required = false) Long categoryId,
                                                                        @RequestParam(defaultValue = "name") String sortBy,
                                                                        @RequestParam(defaultValue = "asc") String sortDir,
                                                                        @RequestParam(defaultValue = "0") Integer pageNumber,
                                                                        @RequestParam(defaultValue = "10") Integer pageSize) {

        Page<Product> productPage = productService.findWithCriteriaApi(search, brandId, categoryId, sortBy, sortDir, pageNumber, pageSize);
        Page<ProductDto> productDtoPage = productPage.map(product -> modelMapper.map(product, ProductDto.class));
        return ResponseEntity.ok(new PagedModel<>(productDtoPage));
    }


}
