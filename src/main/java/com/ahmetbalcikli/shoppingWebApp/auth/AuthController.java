package com.ahmetbalcikli.shoppingWebApp.auth;

import com.ahmetbalcikli.shoppingWebApp.user.entity.User;
import com.ahmetbalcikli.shoppingWebApp.user.mapper.UserMapper;
import com.ahmetbalcikli.shoppingWebApp.user.validation.CurrentUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
@CrossOrigin
public class AuthController {

    @Autowired
    private UserMapper userMapper;

    @PostMapping("/auth")
    public ResponseEntity<?> handleAuthentication(@CurrentUser User user) {

        return ResponseEntity.ok(userMapper.convertToDTO(user));
    }
}
