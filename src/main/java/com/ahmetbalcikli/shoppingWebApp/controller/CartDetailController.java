package com.ahmetbalcikli.shoppingWebApp.controller;

import com.ahmetbalcikli.shoppingWebApp.entity.CartDetail;
import com.ahmetbalcikli.shoppingWebApp.user.entity.User;
import com.ahmetbalcikli.shoppingWebApp.user.validation.CurrentUser;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public interface CartDetailController {

    void saveCart(List<CartDetail> cartDetail);
}
