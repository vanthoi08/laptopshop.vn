package com.example.laptopshop.vn.controller.Admin;

import java.util.List;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.example.laptopshop.vn.domain.User;
import com.example.laptopshop.vn.service.UploadService;
import com.example.laptopshop.vn.service.UserService;

import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;



@Controller
public class UserController {

        private final UserService userService;
        private final UploadService uploadService;
        private final PasswordEncoder passwordEncoder;
        public UserController(UserService userService,UploadService uploadService,PasswordEncoder passwordEncoder) {
            this.userService = userService;
            this.uploadService = uploadService;
            this.passwordEncoder = passwordEncoder;
        }

    // @RequestMapping("/")
    // public String getHomePage(Model model){
    //     List<User> arrUsers = this.userService.getAllUsersByEmail("nv6@gamil.com");
    //     model.addAttribute("test", "from controller with model");
    //     return "hello";
    // }

    @GetMapping("/admin/user/create")
    public String getUserPage(Model model){
        model.addAttribute("newUser", new User());
        return "admin/user/create";
    }

    @PostMapping("/admin/user/create")
    public String createUserPage(Model model, 
                @ModelAttribute("newUser") @Valid User u,BindingResult newUseBindingResult,
                @RequestParam("imgFile") MultipartFile file ){
            
                    List<FieldError> errors = newUseBindingResult.getFieldErrors();
                        for (FieldError error : errors ) {
                        System.out.println (">>>"+error.getField() + " - " + error.getDefaultMessage());
                        }

            // validate
            if(newUseBindingResult.hasErrors()){
                return "admin/user/create";
            }
            //


            String avatar =   this.uploadService.handleSaveUploadFile(file,"avatar");
            String hashPassword = this.passwordEncoder.encode(u.getPassword());

            // Update password and avatar
            u.setPassword(hashPassword);
            u.setAvatar(avatar);
            u.setRole(this.userService.getRoleByName(u.getRole().getName()));
            // save
            this.userService.handleSaveUser(u);
            return "redirect:/admin/user";
    }

    @GetMapping("/admin/user")
    public String getAllUserPage(Model model){
        List<User> users = this.userService.getAllUsers();
        model.addAttribute("listUser", users);
        return "admin/user/show";
    }

    @GetMapping("/admin/user/{id}")
    public String getUserDetailPage(Model model, @PathVariable long id) {
         User user = this.userService.getUserById(id);
        model.addAttribute("user", user);
        model.addAttribute("id", id);
        return "admin/user/detail";
    }
    @GetMapping("/admin/user/update/{id}")
    public String getUpdateUserPage(Model model, @PathVariable long id) {
        User currentUser = this.userService.getUserById(id);
        model.addAttribute("newUser", currentUser);
        return "admin/user/update";
    }

    @PostMapping ("/admin/user/update")
    public String postUpdateUser(Model model,@ModelAttribute("newUser") @Valid User u, BindingResult newUseBindingResult,
                            @RequestParam("imgFile") MultipartFile file) {
            List<FieldError> errors = newUseBindingResult.getFieldErrors();
            for (FieldError error : errors ) {
            System.out.println (">>>"+error.getField() + " - " + error.getDefaultMessage());
            }
          // validate
          if (newUseBindingResult.hasFieldErrors("fullName")) {
            return "admin/user/update";
        }                        
        User currentUser = this.userService.getUserById(u.getId());
        if(currentUser !=null){
                // update new image
                if (!file.isEmpty()) {
                    String img = this.uploadService.handleSaveUploadFile(file, "avatar");
                    currentUser.setAvatar(img);
                }
                currentUser.setAddress(u.getAddress());
                currentUser.setFullName(u.getFullName());
                currentUser.setPhone(u.getPhone());
                currentUser.setRole(this.userService.getRoleByName(u.getRole().getName()));

          // save to data base
          this.userService.handleSaveUser(currentUser);
        }
        return "redirect:/admin/user";
    }

    @GetMapping("/admin/user/delete/{id}")
    public String getDeleteUserPage(Model model, @PathVariable long id) {
        model.addAttribute("id", id);
        model.addAttribute("newUser", new User());
        return "admin/user/delete";
    }

    @PostMapping("/admin/user/delete")
    public String postDeleteUser(Model model,@ModelAttribute("newUser") User u ) {
        this.userService.deleteUser(u.getId());
        return "redirect:/admin/user";
    }


    
}






