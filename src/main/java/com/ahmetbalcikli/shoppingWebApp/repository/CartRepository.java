package com.ahmetbalcikli.shoppingWebApp.repository;

import com.ahmetbalcikli.shoppingWebApp.entity.Cart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CartRepository extends JpaRepository<Cart, Long> {

    @Query("Select c from Cart c WHERE c.user = (SELECT u FROM User u WHERE u.username= ?1)")
    Cart findByUsername(String username);
}
