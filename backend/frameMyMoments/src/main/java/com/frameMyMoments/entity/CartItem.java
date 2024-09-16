package com.frameMyMoments.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "CART_ITEMS")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CartItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne()
    @JoinColumn(name = "product_id")
    @JsonProperty()
    private Product product;
    @ManyToOne()
    @JoinColumn(name = "session_id")
    @JsonProperty()
    private ShoppingSession session;
    private Long quantity;
}
