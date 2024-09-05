package com.frameMyMoments.frameMyMoments.model.dao;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "PRODUCT_REVIEWS")
@Data
@NoArgsConstructor
@AllArgsConstructor

public class ProductReview {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Product product;
    private String review;
}
