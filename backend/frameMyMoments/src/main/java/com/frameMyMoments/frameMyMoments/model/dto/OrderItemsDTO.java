package com.frameMyMoments.frameMyMoments.model.dto;

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
}
