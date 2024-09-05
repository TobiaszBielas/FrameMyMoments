package com.frameMyMoments.frameMyMoments.model.dao;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "ORDER_ITEMS")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private OrderDetail order;
    private Product product;
    private Long quantity;
}
