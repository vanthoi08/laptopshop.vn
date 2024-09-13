package com.example.laptopshop.vn.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.laptopshop.vn.domain.Product;
import com.example.laptopshop.vn.repository.ProductRepository;

@Service
public class ProductService {
    private final ProductRepository  productRepository;
    
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public Product createProduct(Product product) {
        return this.productRepository.save(product);
    }

     public List<Product> fetchProducts(){
        return this.productRepository.findAll();
    }
    public Optional<Product> fetchProductById(long id) {
        return this.productRepository.findById(id);
    }

    public void deleteProduct(long id) {
        this.productRepository.deleteById(id);
    }

}
