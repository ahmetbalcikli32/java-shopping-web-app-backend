package com.ahmetbalcikli.shoppingWebApp.controller.impl;

import com.ahmetbalcikli.shoppingWebApp.controller.CategoryController;
import com.ahmetbalcikli.shoppingWebApp.dto.CategoryDTO;
import com.ahmetbalcikli.shoppingWebApp.mapper.CategoryMapper;
import com.ahmetbalcikli.shoppingWebApp.service.CategoryService;
import com.ahmetbalcikli.shoppingWebApp.tools.response.GenericResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/categories")
public class CategoryControllerImpl implements CategoryController {

    @Autowired
    private CategoryService categoryService;

    @Autowired
    private CategoryMapper categoryMapper;

    @Override
    @GetMapping
    public List<CategoryDTO> findAll() {
        return categoryService.findAll().stream().map(category -> categoryMapper.convertToDTO(category)).collect(Collectors.toList());
    }

    @Override
    @GetMapping("{id}")
    public CategoryDTO findById(long id) {
        return categoryMapper.convertToDTO(categoryService.findById(id));
    }

    @Override
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public GenericResponse saveCategory(CategoryDTO category) {
        if (category != null) {
            categoryService.saveCategory(categoryMapper.convertToEntity(category));
        }
        return new GenericResponse("Kategori eklenirken hata oluştu");
    }

}
