package com.frameMyMoments.model.dao;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "PRODUCTS")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne()
    @JoinColumn()
    @JsonProperty()
    private ProductCategory category;
    @ManyToOne()
    @JoinColumn()
    @JsonProperty()
    private ProductSize size;
    private String name;
    private String description;
    private Long quantity;
    private float price;
}
