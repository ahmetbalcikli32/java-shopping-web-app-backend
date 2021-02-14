package com.ahmetbalcikli.shoppingWebApp.dto;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class ProductDTO {

    private Long id;
    private String title;
    private String description;
    private BigDecimal price;
    private int stockAmount;
    private long categoryId;

}
