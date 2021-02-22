package com.ahmetbalcikli.shoppingWebApp.service;

import com.ahmetbalcikli.shoppingWebApp.entity.CartDetail;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface CartDetailService {

    CartDetail findByUser(Long userId);

    ResponseEntity<List<CartDetail>> saveAllCartDetails(List<CartDetail> cartDetails);

    ResponseEntity<CartDetail> saveCartDetail(CartDetail cartDetail);

    ResponseEntity<CartDetail> updateCartDetail(CartDetail cartDetail);

}
