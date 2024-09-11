package com.example.laptopshop.vn.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.laptopshop.vn.domain.User;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {
    User save(User u);
    
}
