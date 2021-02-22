package com.ahmetbalcikli.shoppingWebApp.repository;

import com.ahmetbalcikli.shoppingWebApp.entity.CartDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CartDetailRepository extends JpaRepository<CartDetail, Long> {
}
