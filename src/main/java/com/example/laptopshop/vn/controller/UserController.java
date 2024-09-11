package com.example.laptopshop.vn.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.laptopshop.vn.service.UserService;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;



@Controller
public class UserController {
        private final UserService userService;
    

        public UserController(UserService userService) {
            this.userService = userService;
        }

    @RequestMapping("/")
    public String getHomePage(Model model){
        String test = this.userService.handleHello();
        model.addAttribute("e", test);
        model.addAttribute("test", "from controller with model");
        return "hello";
    }

    @RequestMapping("/admin/user")
    public String getUserPage(Model model){
        return "admin/user/create";
    }
}






// @RestController
// public class UserController {
//     private final UserService userService;
    

//     public UserController(UserService userService) {
//         this.userService = userService;
//     }

//     @GetMapping("/")
//     public String getHomePage(){
//         return this.userService.handleHello();
//     }
    
// }
