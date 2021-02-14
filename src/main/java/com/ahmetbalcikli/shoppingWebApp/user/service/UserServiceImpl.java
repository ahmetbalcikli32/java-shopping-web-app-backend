package com.ahmetbalcikli.shoppingWebApp.user.service;

import com.ahmetbalcikli.shoppingWebApp.user.entity.Role;
import com.ahmetbalcikli.shoppingWebApp.user.entity.User;
import com.ahmetbalcikli.shoppingWebApp.user.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

@Service
public class UserServiceImpl implements UserService{

    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void createUser(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setEnabled(true);
        user.setRole(Role.ROLE_USER);
        userRepository.save(user);
    }

    @PostConstruct
    public void createAdmin(){
        User user = new User();
        user.setUsername("admin");
        user.setFirstName("admin");
        user.setLastName("test");
        user.setEmail("admin@gmail.com");
        user.setRole(Role.ROLE_ADMIN);
        user.setEnabled(true);
        user.setPassword(passwordEncoder.encode("test.123"));
        userRepository.save(user);
    }
}
