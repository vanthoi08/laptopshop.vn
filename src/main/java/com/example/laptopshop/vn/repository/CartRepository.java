package com.example.laptopshop.vn.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.laptopshop.vn.domain.Cart;
import com.example.laptopshop.vn.domain.User;

@Repository
public interface CartRepository extends JpaRepository<Cart,Long> {

    Cart findByUser(User user);
    
}
