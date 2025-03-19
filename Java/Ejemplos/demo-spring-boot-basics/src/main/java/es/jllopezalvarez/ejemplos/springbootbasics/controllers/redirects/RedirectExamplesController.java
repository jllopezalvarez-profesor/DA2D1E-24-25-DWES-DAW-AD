package es.jllopezalvarez.ejemplos.springbootbasics.controllers.redirects;


import es.jllopezalvarez.ejemplos.springbootbasics.models.common.Category;
import es.jllopezalvarez.ejemplos.springbootbasics.models.common.Product;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.IntStream;

@Controller
@RequestMapping("/redirects")
public class RedirectExamplesController {

    @ModelAttribute(name = "currentUrl")
    public String getCurrentUrl(HttpServletRequest request) {
        //System.out.println("Current URL: " + request.getRequestURI());
        return request.getRequestURI();
    }

    @GetMapping({"", "/"})
    public String index() {
        return "redirect-examples/index";
    }

    /*
     * Genera la página de detalle de producto
     */
    @GetMapping("/product-detail/{productId}")
    public ModelAndView productDetail(@PathVariable Integer productId) {
        String productName = String.format("Producto con id %s", productId);
        Product product = new Product(productId, productName);
        return new ModelAndView("redirect-examples/product-detail", "product", product);
    }

    /*
     * Genera la página de detalle listado de productos en categoría
     */
    @GetMapping("/category-list/{categoryId}")
    public ModelAndView categoryList(@PathVariable String categoryId) {
        String categoryName = String.format("Categoría con id %s", categoryId);
        Category category = new Category(categoryId, categoryName);
        // Creamos productos ficticios para el listado
        List<Product> products = IntStream.range(1, 10)
                .mapToObj(productId ->
                        new Product(productId, String.format("Producto con id %s", productId)))
                .toList();

        ModelAndView modelAndView = new ModelAndView("redirect-examples/category-list");
        modelAndView.addObject("category", category);
        modelAndView.addObject("products", products);

        return modelAndView;
    }

    /*
     * Pensado para añadir el producto al carro desde el detalle de producto, redirige siempre al detalle del producto
     */
    @GetMapping("/add-to-cart/from-product-detail/{productId}")
    public String addToCartFromProductDetail(@PathVariable Integer productId) {
        // Simulamos añadir al carro con un sout
        System.out.println("En añadir producto desde detalle de producto.");
        System.out.printf("Añadiendo el producto con id %s al carro\n", productId);
        return "redirect:/common/product-detail/" + productId;
    }

    /*
     * Pensado para añadir el producto al carro desde el listado de productos en categoría, redirige siempre al listado de la categoría.
     * Necesita recibir el id de la categoría, además del id del producto.
     * Alternativamente, se podría obtener el id de la categoría del producto, pero solo si los productos pertenecen a una sola categoría.
     * Si los productos pertenecen a varias categorías, la única forma es recibir el ID de la categoría
     */
    @GetMapping("/add-to-cart/from-product-detail/{productId}/{categoryId}")
    public String addToCartFromCategoryProducts(@PathVariable Integer productId, @PathVariable String categoryId) {
        // Simulamos añadir al carro con un sout
        System.out.println("En añadir producto desde listado de productos de categoría.");
        System.out.printf("Añadiendo el producto con id %s al carro\n", productId);
        return "redirect:/common/category-list/" + categoryId;

    }

    /*
     * Pensado para añadir desde varias ubicaciones, pero, en lugar de recibir todos los datos en la URL como partes del
     * path (@PathVariable) recibe así el id de producto, y recibe el resto como @RequestParams. Un parámetro es obligatorio,
     * que es el origen (PD = product detail, CL = category list). El otro parámetro es el id de la categoría, que no es
     * obligatorio, porque si se accede desde el detalle de producto no lo tenemos que pasar.
     * Como el patrón de URL es igual que el caso siguiente, con origen por URL, añadimos restricción por parámetro
     */
    @GetMapping(value = "/add-to-cart/{productId}", params = "from")
    public String addToCartWithParam(@PathVariable Integer productId,
                                     @RequestParam(name = "from") String from,
                                     @RequestParam(name = "categoryId", required = false) String categoryId) {
        // Simulamos añadir al carro con un sout
        System.out.println("En añadir producto desde una ubicación recibida como un código en parámetro");
        System.out.println("Se ha recibido " + from);
        System.out.printf("Añadiendo el producto con id %s al carro\n", productId);
        // En función del parámetro (CL / PD), se redirige a una u otra URL)
        if (from.equalsIgnoreCase("PD")) {
            return "redirect:/common/product-detail/" + productId;
        } else if (from.equalsIgnoreCase("CL")) {
            if (categoryId == null) {
                throw new IllegalArgumentException("La categoria no puede ser nula");
            }
            return "redirect:/common/category-list/" + categoryId;
        } else {
            throw new IllegalArgumentException("El origen no es valido");
        }
    }

    /*
     * Pensado para añadir desde varias ubicaciones, pero, en lugar de recibir todos los datos en la URL como partes del
     * path (@PathVariable) recibe así el id de producto, y recibe el resto como @RequestParams. Un parámetro es obligatorio,
     * que es el origen (PD = product detail, CL = category list). El otro parámetro es el id de la categoría, que no es
     * obligatorio, porque si se accede desde el detalle de producto no lo tenemos que pasar.
     * Como el patrón de URL es igual que el caso anterior, con origen codificado, añadimos restricción por parámetro
     */
    @GetMapping(value = "/add-to-cart/{productId}", params = "returnurl")
    public String addToCartWithReturnUrl(@PathVariable Integer productId,
                                         @RequestParam(name = "returnurl") String returnUrl) {
        // Simulamos añadir al carro con un sout
        System.out.println("En añadir producto desde una ubicación recibida como url en parámetro");
        System.out.println("Se ha recibido " + returnUrl);
        System.out.printf("Añadiendo el producto con id %s al carro\n", productId);
        // Se redirige siempre a la URL de origen
        return "redirect:" + returnUrl;
    }


    /*
     * Genera la página incial del ejemplo de uso de flash attributes.
     * Muestra una página en la que se puede comprobar la fecha y hora de generación de la página.
     * Esta página, en la plantilla, recupera los atributos "flash" para poder mostrar mensajes en función
     * de si se ha fijado alguno, antes de que se haga una redirección.
     */
    @GetMapping("/flash-attributes/start")
    public ModelAndView flashAttributesDemoStart(@ModelAttribute("errorMessage") String errorMessage) {

        if (errorMessage == null) {}
        System.out.println("Se ha recibido un atributo de flash attribute con el valor " + errorMessage);

        return new ModelAndView("redirect-examples/flash-attributes/start", "createdAt", LocalDateTime.now());
    }

    @GetMapping("/flash-attributes/form")
    public ModelAndView flashAttributesDemoForm() {
        return new ModelAndView("redirect-examples/flash-attributes/form");
    }


    @PostMapping("/flash-attributes/form/option-ok")
    public String flashAttributesDemoFormPostOk(RedirectAttributes redirectAttributes) {
        redirectAttributes.addFlashAttribute("successMessage", "Esto es un mensaje de éxito");
        return "redirect:/redirects/flash-attributes/start";
    }

    @PostMapping("/flash-attributes/form/option-error")
    public String flashAttributesDemoFormPostError(RedirectAttributes redirectAttributes) {
        redirectAttributes.addFlashAttribute("errorMessage", "Esto es un mensaje de error");
        return "redirect:/redirects/flash-attributes/start";
    }
}
