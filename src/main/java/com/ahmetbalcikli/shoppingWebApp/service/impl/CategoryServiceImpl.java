package com.ahmetbalcikli.shoppingWebApp.service.impl;

import com.ahmetbalcikli.shoppingWebApp.entity.Category;
import com.ahmetbalcikli.shoppingWebApp.repository.CategoryRepository;
import com.ahmetbalcikli.shoppingWebApp.service.CategoryService;
import com.ahmetbalcikli.shoppingWebApp.tools.response.GenericResponse;
import com.ahmetbalcikli.shoppingWebApp.tools.exceptions.RecordNotFountException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class CategoryServiceImpl implements CategoryService {

    private CategoryRepository categoryRepository;

    public CategoryServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public List<Category> findAll() {
        return categoryRepository.findAll();
    }

    @Override
    public Category findById(long id) {
        return categoryRepository.findById(id).orElseThrow(() -> new RecordNotFountException("Kategori bulunamadı"));
    }

    @Override
    public GenericResponse saveCategory(Category entity) {
        Category category = categoryRepository.findByName(entity.getName());
        if (category == null) {
            return new GenericResponse("Kategori eklendi");
        } else {
            return new GenericResponse("Kategori zaten mevcut");
        }
    }
}
