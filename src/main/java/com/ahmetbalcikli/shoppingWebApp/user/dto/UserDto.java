package com.ahmetbalcikli.shoppingWebApp.user.dto;

import com.ahmetbalcikli.shoppingWebApp.entity.Cart;
import lombok.Data;

@Data
public class UserDto {

    private String username;
    private String firstName;
    private String lastName;
    private String email;
    private Integer cartId;

}
