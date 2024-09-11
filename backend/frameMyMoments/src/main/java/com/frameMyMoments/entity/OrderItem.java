package com.frameMyMoments.entity;
import com.fasterxml.jackson.annotation.JsonProperty;
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
    @ManyToOne()
    @JoinColumn(name = "order_id")
    @JsonProperty()
    private OrderDetails orderDetails;
    @ManyToOne()
    @JoinColumn(name = "product_id")
    @JsonProperty()
    private Product product;
    private Long quantity;
}
