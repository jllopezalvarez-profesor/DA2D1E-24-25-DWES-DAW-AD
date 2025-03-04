package es.lopezalvarezjoseluis.ejemplos.ejemplo99tiendaonline.controllers.admin;

import es.lopezalvarezjoseluis.ejemplos.ejemplo99tiendaonline.services.CategoryService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/admin/categories")
public class CategoryAdminController {

    private final CategoryService categoryService;

    public CategoryAdminController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping({"/", ""})
    public String index(@RequestParam(defaultValue = "1") Integer pageNumber,
                        @RequestParam(defaultValue = "2") Integer pageSize,
                        @RequestParam(defaultValue = "name") String orderBy,
                        @RequestParam(defaultValue = "asc") String orderDir,
                        Model model) {
        model.addAttribute("categories", categoryService.findAll(pageNumber, pageSize, orderBy, orderDir));
        return "admin/categories/list";
    }
}
