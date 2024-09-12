package com.example.laptopshop.vn.controller;

import java.util.List;

import org.apache.el.stream.Optional;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.laptopshop.vn.domain.User;
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
        List<User> arrUsers = this.userService.getAllUsersByEmail("nv6@gamil.com");
        model.addAttribute("test", "from controller with model");
        return "hello";
    }

    @RequestMapping("/admin/user/create")
    public String getUserPage(Model model){
        model.addAttribute("newUser", new User());
        return "admin/user/create";
    }

    @RequestMapping(value = "/admin/user/create", method = RequestMethod.POST)
    public String createUserPage(Model model, @ModelAttribute("newUser") User u){
        this.userService.handleSaveUser(u);
        return "redirect:/admin/user";
    }

    @RequestMapping("/admin/user")
    public String getAllUserPage(Model model){
        List<User> users = this.userService.getAllUsers();
        model.addAttribute("listUser", users);
        return "admin/user/table-user";
    }

    @GetMapping("/admin/user/{id}")
    public String getUserDetailPage(Model model, @PathVariable long id) {
        System.out.println("check path id = "+id);
         User user = this.userService.getUserById(id);
        model.addAttribute("user", user);
        model.addAttribute("id", id);
        return "admin/user/show";

    }
    
}






