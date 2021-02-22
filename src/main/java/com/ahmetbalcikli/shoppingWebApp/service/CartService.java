package com.ahmetbalcikli.shoppingWebApp.service;

import com.ahmetbalcikli.shoppingWebApp.entity.Cart;
import org.springframework.http.ResponseEntity;

public interface CartService {

    Cart findByUser(String username);

    ResponseEntity<Cart> saveCart(Cart cart);

    ResponseEntity<Cart> updateCart(Cart cart);

}
