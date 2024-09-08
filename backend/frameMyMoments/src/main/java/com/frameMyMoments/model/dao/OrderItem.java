package com.frameMyMoments.model.dao;
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
    @JoinColumn()
    @JsonProperty()
    private OrderDetail order;
    @ManyToOne()
    @JoinColumn()
    @JsonProperty()
    private Product product;
    private Long quantity;
}
