package com.frameMyMoments.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.util.List;

@Entity
@Table(name = "PRODUCTS")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "image_url", nullable = false)
    private String imageUrl;
    @ManyToOne()
    @JoinColumn()
    @JsonProperty()
    private ProductCategory category;
    @ManyToOne()
    @JoinColumn()
    @JsonProperty()
    private ProductSize size;
    @Column(nullable = false)
    private String name;
    private String description;
    @Column(nullable = false)
    private Long quantity;
    @Column(nullable = false)
    private BigDecimal price;

    @OneToMany(mappedBy = "product")
    private List<ProductReview> productReviews;
}
