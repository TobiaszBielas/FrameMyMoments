package com.frameMyMoments.frameMyMoments.model.dao;

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
    private ProductCategory category;
    private ProductSize size;
    private String name;
    private String description;
    private Long quantity;
    private float price;
}
