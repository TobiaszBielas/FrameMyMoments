package com.frameMyMoments.entity;
import com.fasterxml.jackson.annotation.JsonProperty;
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
    @ManyToOne()
    @JoinColumn(name = "product_id", nullable = false)
    @JsonProperty()
    private Product product;
    private String review;
}
