package com.ahmetbalcikli.shoppingWebApp.repository;

import com.ahmetbalcikli.shoppingWebApp.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface ProductRepository extends JpaRepository<Product, Long> {

    @Query("FROM Product WHERE category.id = ?1")
    Optional<Product> findByCategoryId(Long categoryId);

    Optional<Product> findByTitle(String title);
}
