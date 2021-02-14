package com.ahmetbalcikli.shoppingWebApp.user.validation;

import com.ahmetbalcikli.shoppingWebApp.user.entity.User;
import com.ahmetbalcikli.shoppingWebApp.user.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.Optional;

public class UniqueEmailValidator implements ConstraintValidator<UniqueEmail, String> {

    @Autowired
    private UserRepository userRepository;

    @Override
    public boolean isValid(String email, ConstraintValidatorContext context) {
        Optional<User> user = userRepository.findByEmail(email);
        if (!user.isEmpty()) {
            return false;
        }
        return true;
    }
}
