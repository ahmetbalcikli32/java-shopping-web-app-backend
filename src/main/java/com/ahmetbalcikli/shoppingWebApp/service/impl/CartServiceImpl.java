package com.ahmetbalcikli.shoppingWebApp.service.impl;

import com.ahmetbalcikli.shoppingWebApp.entity.Cart;
import com.ahmetbalcikli.shoppingWebApp.repository.CartRepository;
import com.ahmetbalcikli.shoppingWebApp.service.CartService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class CartServiceImpl implements CartService {

    private CartRepository cartRepository;

    public CartServiceImpl(CartRepository cartRepository) {
        this.cartRepository = cartRepository;
    }

    @Override
    public Cart findByUser(String username) {
        return cartRepository.findByUsername(username);
    }

    @Override
    public ResponseEntity<Cart> saveCart(Cart cart) {
        cartRepository.save(cart);
        return ResponseEntity.ok(cart);
    }

    @Override
    public ResponseEntity<Cart> updateCart(Cart cart) {
        return null;
    }
}
