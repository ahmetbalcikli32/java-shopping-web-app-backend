package com.ahmetbalcikli.shoppingWebApp.entity;

import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "cart_details")
@Data
public class CartDetail {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "cart_id", foreignKey = @ForeignKey(name = "cart_details_fkey_carts"))
    private Cart cart;

    @OneToOne()
    @JoinColumn(name = "product_id", foreignKey = @ForeignKey(name = "cart_details_fkey_products"))
    private Product product;

    @Column(name = "quantity", nullable = false)
    private Integer quantity;

}
