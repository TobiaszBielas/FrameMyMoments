package com.frameMyMoments.model.dao;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "PRODUCT_CATEGORY")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductCategory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
}
