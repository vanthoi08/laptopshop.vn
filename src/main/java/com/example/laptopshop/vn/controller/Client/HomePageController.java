package com.example.laptopshop.vn.controller.Client;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class HomePageController {
    
    @GetMapping("/")
    public String getHomePage() {
        return "client/homepage/show";
    }
    
}
