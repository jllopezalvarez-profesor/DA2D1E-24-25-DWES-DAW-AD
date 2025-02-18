package es.lopezalvarezjoseluis.ejemplos.ejemplo99tiendaonline.controllers;

import es.lopezalvarezjoseluis.ejemplos.ejemplo99tiendaonline.services.CategoryService;
import es.lopezalvarezjoseluis.ejemplos.ejemplo99tiendaonline.services.ProductService;
import es.lopezalvarezjoseluis.ejemplos.ejemplo99tiendaonline.services.ProductServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/products")
public class ProductController extends BaseController {

    private final ProductService productService;

    public ProductController(CategoryService categoryService, ProductService productService) {
        super(categoryService);
        this.productService = productService;
    }

    @GetMapping({"", "/"})
    public ModelAndView allProducts() {
        ModelAndView modelAndView = new ModelAndView("products/all");
        modelAndView.addObject("products", productService.findAll());
        return modelAndView;
    }

    @GetMapping("/by-category/{categoryId}")
    public ModelAndView productsByCategory(@PathVariable Long categoryId) {
        ModelAndView modelAndView = new ModelAndView("products/by-category");
        modelAndView.addObject("category", getCategoryService().findById(categoryId).orElseThrow());
        modelAndView.addObject("products", productService.findAllByCategoryId(categoryId));
        return modelAndView;
    }


}
