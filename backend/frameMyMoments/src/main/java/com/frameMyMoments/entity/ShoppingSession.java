package com.frameMyMoments.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;

@Getter
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
    @JoinColumn(name = "user_id")
    @JsonProperty()
    private User user;
//    private boolean status;
    private BigDecimal totalPrice;
}
