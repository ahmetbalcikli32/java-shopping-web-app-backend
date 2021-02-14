package com.ahmetbalcikli.shoppingWebApp.repository;

import com.ahmetbalcikli.shoppingWebApp.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {

    Category findByName(String name);
}
