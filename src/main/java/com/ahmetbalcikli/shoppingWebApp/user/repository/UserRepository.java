package com.ahmetbalcikli.shoppingWebApp.user.repository;

import com.ahmetbalcikli.shoppingWebApp.user.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByUsername(String username);

    Optional<User> findByEmail(String email);
}
