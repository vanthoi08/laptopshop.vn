package com.example.laptopshop.vn.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.laptopshop.vn.domain.User;
import com.example.laptopshop.vn.repository.UserRepository;
import com.example.laptopshop.vn.service.UserService;




@Controller
public class UserController {
        private final UserService userService;
    

        public UserController(UserService userService) {
            this.userService = userService;
        }

    @RequestMapping("/")
    public String getHomePage(Model model){
        List<User> arrUsers = this.userService.getAllUsersByEmail("nv6@gamil.com");
        System.out.println(arrUsers.size());
        model.addAttribute("test", "from controller with model");
        return "hello";
    }

    @RequestMapping("/admin/user")
    public String getUserPage(Model model){
        model.addAttribute("newUser", new User());
        return "admin/user/create";
    }

    @RequestMapping(value = "/admin/user/create", method = RequestMethod.POST)
    public String createUserPage(Model model, @ModelAttribute("newUser") User u){
        System.out.println("run here :" + u);
        this.userService.handleSaveUser(u);
        return "hello";
    }
}






