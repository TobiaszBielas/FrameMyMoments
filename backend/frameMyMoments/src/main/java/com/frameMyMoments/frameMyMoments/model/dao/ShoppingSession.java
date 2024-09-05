package com.frameMyMoments.frameMyMoments.model.dao;

import com.fasterxml.jackson.annotation.JsonProperty;
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
    @OneToOne()
    @JoinColumn()
    @JsonProperty()
    private User user;
    private float totalPrice;
}
