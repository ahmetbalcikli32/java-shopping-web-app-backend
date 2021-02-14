package com.ahmetbalcikli.shoppingWebApp.service;

import com.ahmetbalcikli.shoppingWebApp.entity.Category;
import com.ahmetbalcikli.shoppingWebApp.tools.response.GenericResponse;

import java.util.List;

public interface CategoryService {

    List<Category> findAll();

    Category findById(long id);

    GenericResponse saveCategory(Category entity);
}
