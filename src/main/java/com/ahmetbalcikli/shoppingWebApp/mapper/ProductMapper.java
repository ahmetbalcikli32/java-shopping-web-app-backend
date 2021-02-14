package com.ahmetbalcikli.shoppingWebApp.mapper;

import com.ahmetbalcikli.shoppingWebApp.dto.ProductDTO;
import com.ahmetbalcikli.shoppingWebApp.entity.Product;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ProductMapper {

    @Mapping(source = "category.id", target = "categoryId")
    ProductDTO convertToDTO(Product product);

    @InheritInverseConfiguration(name = "convertToDTO")
    Product convertToEntity(ProductDTO productDTO);
}
