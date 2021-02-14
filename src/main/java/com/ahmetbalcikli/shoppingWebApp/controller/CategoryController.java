package com.ahmetbalcikli.shoppingWebApp.controller;

import com.ahmetbalcikli.shoppingWebApp.dto.CategoryDTO;
import com.ahmetbalcikli.shoppingWebApp.tools.response.GenericResponse;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public interface CategoryController {

    List<CategoryDTO> findAll();

    CategoryDTO findById(@PathVariable long id);

    GenericResponse saveCategory(@RequestBody CategoryDTO category);
}
