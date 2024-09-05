package com.frameMyMoments.frameMyMoments.model.dao;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "SHOPPING_SESSION")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ShoppingSession {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private User user;
    private float totalPrice;
}
