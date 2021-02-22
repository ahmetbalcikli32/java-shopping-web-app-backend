package com.ahmetbalcikli.shoppingWebApp.controller.impl;

import com.ahmetbalcikli.shoppingWebApp.controller.CartDetailController;
import com.ahmetbalcikli.shoppingWebApp.entity.Cart;
import com.ahmetbalcikli.shoppingWebApp.entity.CartDetail;
import com.ahmetbalcikli.shoppingWebApp.entity.Product;
import com.ahmetbalcikli.shoppingWebApp.service.CartDetailService;
import com.ahmetbalcikli.shoppingWebApp.service.CartService;
import com.ahmetbalcikli.shoppingWebApp.user.entity.User;
import com.ahmetbalcikli.shoppingWebApp.user.validation.CurrentUser;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api")
public class CartDetailControllerImpl implements CartDetailController {

    @Autowired
    private CartDetailService cartDetailService;

    @Autowired
    private CartService cartService;

    @Override
    @PostMapping("/cartDetails")
    public void saveCart(@RequestBody List<CartDetail> entity) {

        Cart cart = new Cart();
//        System.out.println(SecurityContextHolder.getContext().getAuthentication().getPrincipal());
//        if (user == null) {
//            System.out.println("user boş");
//        } else if (user instanceof User) {
//            cart = cartService.findByUser(user.getUsername());
//            System.out.println(user);
//        } else {
//            System.out.println(user.toString());
//        }

        BigDecimal totalPrice = entity.stream()
                .map(product -> product.getProduct().getPrice().multiply(BigDecimal.valueOf(product.getQuantity())))
                .reduce(BigDecimal.ZERO, BigDecimal::add);

        for (CartDetail cartDetail : entity) {
            cart.getCartDetails().add(cartDetail);
            cartDetail.setCart(cart);
            cartDetailService.saveCartDetail(cartDetail);
        }

        cart.setTotalPrice(totalPrice);
        cartService.saveCart(cart);

    }
}
