package com.ahmetbalcikli.shoppingWebApp.controller.impl;

import com.ahmetbalcikli.shoppingWebApp.controller.ProductController;
import com.ahmetbalcikli.shoppingWebApp.dto.ProductDTO;
import com.ahmetbalcikli.shoppingWebApp.mapper.ProductMapper;
import com.ahmetbalcikli.shoppingWebApp.service.ProductService;
import com.ahmetbalcikli.shoppingWebApp.tools.response.GenericResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/products")
public class ProductControllerImpl implements ProductController {

    @Autowired
    private ProductService productService;

    @Autowired
    private ProductMapper productMapper;

    @Override
    @GetMapping
    public List<ProductDTO> findAll() {
        return productService.findAll().stream().map(product -> productMapper.convertToDTO(product)).collect(Collectors.toList());
    }

    @Override
    @GetMapping("{id}")
    public ProductDTO findById(long id) {
        return productMapper.convertToDTO(productService.findById(id));
    }

    @Override
    @GetMapping(params = "category_id")
    public List<ProductDTO> findProductsByCategory(@RequestParam("category_id") long categoryId) {
        return productService.findByCategory(categoryId).stream().map(product -> productMapper.convertToDTO(product)).collect(Collectors.toList());
    }

    @Override
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public GenericResponse saveProduct(ProductDTO product) {

        if (product != null) {
            productService.saveProduct(productMapper.convertToEntity(product));
        }
        return new GenericResponse("Ürün kaydedilirken hata oluştu");
    }
}
