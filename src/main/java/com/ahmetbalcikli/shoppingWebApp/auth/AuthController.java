package com.ahmetbalcikli.shoppingWebApp.auth;

import com.ahmetbalcikli.shoppingWebApp.user.entity.User;
import com.ahmetbalcikli.shoppingWebApp.user.mapper.UserMapper;
import com.ahmetbalcikli.shoppingWebApp.user.validation.CurrentUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@RestController
@RequestMapping("/api")
@CrossOrigin
public class AuthController {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private AuthenticationManager authenticationManager;

    @PostMapping("/auth")
    public ResponseEntity<?> handleAuthentication(@CurrentUser User user) {

        System.out.println(user.getEmail());
        return ResponseEntity.ok(userMapper.convertToDTO(user));
    }

}
