package com.example.laptopshop.vn.service;

import org.springframework.stereotype.Service;

import com.example.laptopshop.vn.domain.User;
import com.example.laptopshop.vn.repository.UserRepository;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public String handleHello() {
        return "hello from service";
    }

    public User handleSaveUser(User user) {
        User u = this.userRepository.save(user);
        return u;
    }

}
