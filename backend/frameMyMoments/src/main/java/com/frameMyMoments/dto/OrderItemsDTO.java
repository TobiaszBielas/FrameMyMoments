package com.frameMyMoments.dto;

import com.frameMyMoments.entity.OrderDetails;
import com.frameMyMoments.entity.OrderItem;
import com.frameMyMoments.entity.Product;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@AllArgsConstructor
@RequiredArgsConstructor
public class OrderItemsDTO {
    private Long id;
    private Long orderId;
    private Long productId;
    private Long quantity;

    public static OrderItemsDTO fromEntity(OrderItem orderItem) {
        return new OrderItemsDTO(
                orderItem.getId(),
                orderItem.getOrderDetails() != null ? orderItem.getOrderDetails().getId() : null,
                orderItem.getProduct() != null ? orderItem.getProduct().getId() : null,
                orderItem.getQuantity()
        );
    }

    public static OrderItem toEntity(OrderItemsDTO orderItemDTO, OrderDetails orderDetails, Product product) {
        OrderItem orderItem = new OrderItem();
        orderItem.setId(orderItemDTO.getId());
        orderItem.setOrderDetails(orderDetails);
        orderItem.setProduct(product);
        orderItem.setQuantity(orderItemDTO.getQuantity());
        return orderItem;
    }
}
