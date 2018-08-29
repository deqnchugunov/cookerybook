package cookerybook.controllers;

import cookerybook.entities.Category;
import cookerybook.entities.Receipt;
import cookerybook.services.base.CategoriesService;
import cookerybook.services.base.ReceiptsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.*;

@Controller
public class ReceiptController {

    private final ReceiptsService receiptsService;
    private final CategoriesService categoriesService;

    @Autowired
    public ReceiptController(ReceiptsService receiptsService, CategoriesService baseCategoriesService) {
        this.receiptsService = receiptsService;
        this.categoriesService = baseCategoriesService;
    }

    @GetMapping("/receipts")
    public String getAllReceipts(Model model) {
        List<Receipt> receipts = receiptsService.getAllReceipts();
        model.addAttribute("receipts", receipts);
        return "receipts/all";
    }

    @GetMapping("/receipts/{id}")
    public String getReceiptDetails(@PathVariable String id, Model model) {
        Receipt receipt = receiptsService.getReceiptById(Integer.parseInt(id));
        model.addAttribute("receipt", receipt);
        return "receipts/details";
    }

    @GetMapping("/receipts/create")
    public String createNewReceipt(Model model) {
        Receipt receipt = new Receipt();
        List<Category> categories = categoriesService.getAllCategories();
        model.addAttribute("receipt", receipt);
        model.addAttribute("categories", categories);
        return "receipts/create";
    }

    @PostMapping("/receipts/create")
    public String createNewReceipt(@ModelAttribute Receipt receipt) {
        receiptsService.createReceipt(receipt);
        return "redirect:/receipts";
    }

    @GetMapping(value= "/receipts", params = "category")
    public String getReceiptsByCategory(Model model, @RequestParam("category") String category) {
        List<Receipt> receipts;

        if (category == null) {
            receipts = receiptsService.getAllReceipts();
        } else {
            receipts = receiptsService.getReceiptsByCategory(category);
        }
        model.addAttribute("receipts", receipts);
        model.addAttribute("category", category);
        return "receipts/receiptsByCategory";
    }

    @GetMapping("/receipts/edit/{id}")
    public String editReceiptById(@PathVariable String id, Model model) {
        List<Category> categories = categoriesService.getAllCategories();
        Receipt receipt = receiptsService.getReceiptById(Integer.parseInt(id));
        model.addAttribute("receipt", receipt);
        model.addAttribute("categories", categories);
        return "receipts/edit";
    }

    @PostMapping("/receipts/edit/{id}")
    public String editReceiptById(@ModelAttribute Receipt receipt) {
        receiptsService.updateReceipt(receipt);
        return "redirect:/receipts";
    }

    @GetMapping("/receipts/delete/{id}")
    public String deleteReceiptById(@PathVariable String id, Model model) {
        Receipt receipt = receiptsService.getReceiptById(Integer.parseInt(id));
        model.addAttribute("receipt", receipt);
        return "receipts/delete";
    }

    @PostMapping("/receipts/delete/{id}")
    public String deleteReceiptById(@ModelAttribute Receipt receipt) {
        receiptsService.deleteReceipt(receipt);
        return "redirect:/receipts";
    }
}
