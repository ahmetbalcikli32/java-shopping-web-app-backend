package com.ahmetbalcikli.shoppingWebApp.service;

import com.ahmetbalcikli.shoppingWebApp.entity.Product;
import com.ahmetbalcikli.shoppingWebApp.tools.response.GenericResponse;

import java.util.List;
import java.util.Optional;

public interface ProductService {

    List<Product> findAll();

    Product findById(long id);

    Optional<Product> findByCategory(long categoryId);

    GenericResponse saveProduct(Product entity);
}
