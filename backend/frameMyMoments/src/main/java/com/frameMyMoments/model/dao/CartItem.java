package com.frameMyMoments.model.dao;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "CART_ITEMS")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CartItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne()
    @JoinColumn()
    @JsonProperty()
    private Product product;
    @ManyToOne()
    @JoinColumn()
    @JsonProperty()
    private ShoppingSession session;
    private Long quantity;
}
