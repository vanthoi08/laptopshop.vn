package com.example.laptopshop.vn.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.laptopshop.vn.domain.Cart;
import com.example.laptopshop.vn.domain.CartDetail;
import com.example.laptopshop.vn.domain.Product;

@Repository
public interface CartDetailRepository extends JpaRepository<CartDetail, Long>{
    boolean existsByCartAndProduct(Cart cart, Product product);
    CartDetail findByCartAndProduct(Cart cart, Product product);
}
