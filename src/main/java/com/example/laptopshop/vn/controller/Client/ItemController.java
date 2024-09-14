package com.example.laptopshop.vn.controller.Client;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.laptopshop.vn.domain.Product;
import com.example.laptopshop.vn.service.ProductService;


@Controller
public class ItemController {
    private final ProductService productService;
    
    
    public ItemController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/product/{id}")
    public String getProductDetailPage(Model model, @PathVariable long id) {
         Product pr = this.productService.fetchProductById(id).get();
            model.addAttribute("product", pr);
            model.addAttribute("id", id);
            return "client/product/detail";
    }
    
    
}
