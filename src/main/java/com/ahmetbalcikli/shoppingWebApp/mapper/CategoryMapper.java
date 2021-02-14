package com.ahmetbalcikli.shoppingWebApp.mapper;

import com.ahmetbalcikli.shoppingWebApp.dto.CategoryDTO;
import com.ahmetbalcikli.shoppingWebApp.entity.Category;
import org.mapstruct.*;

@Mapper(componentModel = "spring")
public interface CategoryMapper {

    @Mapping(source = "name", target = "name")
    @Mapping(source = "products", target = "products")
    CategoryDTO convertToDTO(Category category);

    @InheritInverseConfiguration(name = "convertToDTO")
    Category convertToEntity(CategoryDTO categoryDTO);
}
