package com.ahmetbalcikli.shoppingWebApp.controller;

import com.ahmetbalcikli.shoppingWebApp.dto.ProductDTO;
import com.ahmetbalcikli.shoppingWebApp.tools.response.GenericResponse;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public interface ProductController {

    List<ProductDTO> findAll();

    ProductDTO findById(@PathVariable long id);

    List<ProductDTO> findProductsByCategory(long categoryId);

    GenericResponse saveProduct(@RequestBody ProductDTO product);
}
