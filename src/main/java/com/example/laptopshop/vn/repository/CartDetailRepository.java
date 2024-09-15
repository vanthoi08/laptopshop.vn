package com.example.laptopshop.vn.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.laptopshop.vn.domain.CartDetail;

@Repository
public interface CartDetailRepository extends JpaRepository<CartDetail, Long>{
    
}
