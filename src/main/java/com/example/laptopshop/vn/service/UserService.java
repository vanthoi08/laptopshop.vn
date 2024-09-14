package com.example.laptopshop.vn.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.laptopshop.vn.domain.Role;
import com.example.laptopshop.vn.domain.User;
import com.example.laptopshop.vn.domain.dto.RegisterDTO;
import com.example.laptopshop.vn.repository.RoleRepository;
import com.example.laptopshop.vn.repository.UserRepository;

@Service
public class UserService {
    private final UserRepository userRepository;
    private final RoleRepository roleRepository;

    public UserService(UserRepository userRepository,RoleRepository roleRepository) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
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

    public void deleteUser(long id){
         this.userRepository.deleteById(id);
    }

    public Role getRoleByName(String name){
        return this.roleRepository.findByName(name);
    }

    public User registerDTOtoUser (RegisterDTO registerDTO){
        User user = new User();
        user.setFullName(registerDTO.getFirstName() + "" + registerDTO.getLastName());
        user.setEmail(registerDTO.getEmail());
        user.setPassword((registerDTO.getPassword()));

        return user;
    }

    public boolean checkEmailExist(String email){
        return this.userRepository.existsByEmail(email);
    }


}
