package com.ahmetbalcikli.shoppingWebApp.service.impl;

import com.ahmetbalcikli.shoppingWebApp.entity.CartDetail;
import com.ahmetbalcikli.shoppingWebApp.repository.CartDetailRepository;
import com.ahmetbalcikli.shoppingWebApp.service.CartDetailService;
import com.ahmetbalcikli.shoppingWebApp.tools.exceptions.RecordNotFountException;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class CartDetailServiceImpl implements CartDetailService {

    private CartDetailRepository cartDetailRepository;

    public CartDetailServiceImpl(CartDetailRepository cartDetailRepository) {
        this.cartDetailRepository = cartDetailRepository;
    }

    @Override
    public CartDetail findByUser(Long userId) {
        return null;
    }

    @Override
    public ResponseEntity<List<CartDetail>> saveAllCartDetails(List<CartDetail> cartDetails) {
        cartDetailRepository.saveAll(cartDetails);
        return ResponseEntity.ok(cartDetails);
    }

    @Override
    public ResponseEntity<CartDetail> saveCartDetail(CartDetail cartDetail) {
        cartDetailRepository.save(cartDetail);
        return ResponseEntity.ok(cartDetail);
    }

    @Override
    public ResponseEntity<CartDetail> updateCartDetail(CartDetail entity) {
//        CartDetail cartDetail = cartDetailRepository.findById().orElseThrow(() -> new RecordNotFountException());
        return null;
    }
}
