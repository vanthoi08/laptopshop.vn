package com.example.laptopshop.vn.service;

import java.util.List;
import java.util.Optional;

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

    public List<User> getAllUsers(){
        return this.userRepository.findAll();
    }

    public List<User> getAllUsersByEmail(String email){
        return this.userRepository.findByEmail(email);
    }

    public User getUserById(long id){
        return this.userRepository.findById(id);
    }


}
