package com.example.laptopshop.vn.controller.Client;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.example.laptopshop.vn.domain.Product;
import com.example.laptopshop.vn.domain.dto.RegisterDTO;
import com.example.laptopshop.vn.service.ProductService;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;




@Controller
public class HomePageController {
    private final ProductService productService;
    
    
    public HomePageController(ProductService productService) {
        this.productService = productService;
    }


    @GetMapping("/")
    public String getHomePage(Model model) {
         List<Product> products =  this.productService.fetchProducts();
         model.addAttribute("products", products);
        return "client/homepage/show";
    }
    @GetMapping("/register")
    public String getRegister(Model model) {
        model.addAttribute("registerUser", new RegisterDTO());
        return "client/auth/register";
    }
    @PostMapping("/register")
    public String handleRegister(@ModelAttribute("registerUser") RegisterDTO registerDTO ) {
        //TODO: process POST request
        
        return "client/auth/register";
    }
    
    
    
}
