package com.example.laptopshop.vn.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.laptopshop.vn.service.UserService;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;



// @Controller
// public class UserController {

//     @RequestMapping("/")
//     public String getHomePage(){
//         return "hello from controller";
//     }
    
// }


@RestController
public class UserController {
    private final UserService userService;
    

    public UserController(UserService userService) {
        this.userService = userService;
    }


    @GetMapping("/")
    public String getHomePage(){
        return this.userService.handleHello();
    }
    
}
