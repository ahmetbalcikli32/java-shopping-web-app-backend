package com.ahmetbalcikli.shoppingWebApp.dto;

import lombok.Data;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Data
public class CategoryDTO {

    private Long id;
    private String name;
    private Set<ProductDTO> products = new HashSet<>();
}
