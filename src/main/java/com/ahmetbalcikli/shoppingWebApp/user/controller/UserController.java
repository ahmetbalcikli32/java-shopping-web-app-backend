package com.ahmetbalcikli.shoppingWebApp.user.controller;

import com.ahmetbalcikli.shoppingWebApp.tools.exceptions.ApiError;
import com.ahmetbalcikli.shoppingWebApp.tools.response.GenericResponse;
import com.ahmetbalcikli.shoppingWebApp.user.entity.User;
import com.ahmetbalcikli.shoppingWebApp.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/users")
    @ResponseStatus(HttpStatus.CREATED)
    public GenericResponse createUser(@Valid @RequestBody User user) {

        userService.createUser(user);
        return new GenericResponse("Kullanıcı başarıyla oluşturuldu");
    }

}
