package com.example.laptopshop.vn.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.laptopshop.vn.domain.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product,Long> {

    //   List<Product> findAll();
}
