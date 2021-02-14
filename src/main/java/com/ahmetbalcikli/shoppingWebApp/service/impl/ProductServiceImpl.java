package com.ahmetbalcikli.shoppingWebApp.service.impl;

import com.ahmetbalcikli.shoppingWebApp.entity.Product;
import com.ahmetbalcikli.shoppingWebApp.repository.ProductRepository;
import com.ahmetbalcikli.shoppingWebApp.service.ProductService;
import com.ahmetbalcikli.shoppingWebApp.tools.response.GenericResponse;
import com.ahmetbalcikli.shoppingWebApp.tools.exceptions.RecordNotFountException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class ProductServiceImpl implements ProductService {

    private ProductRepository productRepository;

    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public List<Product> findAll() {
        return productRepository.findAll();
    }

    @Override
    public Product findById(long id) {
        return productRepository.findById(id).orElseThrow(() -> new RecordNotFountException("Ürün bulunamadı"));
    }

    @Override
    public Optional<Product> findByCategory(long categoryId) {
        return Optional.ofNullable(productRepository.findByCategoryId(categoryId).orElse(null));
    }

    @Override
    public GenericResponse saveProduct(Product entity) {

        Optional<Product> product = productRepository.findByTitle(entity.getTitle());
        if (product.isEmpty()) {
            productRepository.save(entity);
            return new GenericResponse("Ürün kaydedildi");
        } else {
            return new GenericResponse("Ürün zaten mevcut");
        }
    }
}
