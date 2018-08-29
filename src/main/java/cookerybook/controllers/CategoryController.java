package cookerybook.controllers;

import cookerybook.entities.Category;
import cookerybook.services.base.CategoriesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
@Controller
@RequestMapping("/categories")
public class CategoryController {

    private final CategoriesService categoriesService;

    @Autowired
    public CategoryController(CategoriesService categoriesService) {
        this.categoriesService = categoriesService;
    }

    @GetMapping("")
    public String all(Model model) {
        List<Category> categories = categoriesService.getAllCategories();
        model.addAttribute("categories", categories);
        return "categories/all";
    }
}
