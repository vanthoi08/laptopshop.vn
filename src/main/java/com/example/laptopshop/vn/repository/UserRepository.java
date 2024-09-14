package com.example.laptopshop.vn.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.laptopshop.vn.domain.User;
import java.util.List;


@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    User save(User u);

    // List<User> findByEmail(String email);

    List<User> findAll();

    User  findById(long id);

    void deleteById(long id);

    boolean existsByEmail(String email);

    User findByEmail(String email);
    


}
