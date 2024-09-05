package com.frameMyMoments.frameMyMoments.model.dao;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "PRODUCT_SIZE")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductSize {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private float shape;
    private float height;
    private float width;
    private float diameter;
}
