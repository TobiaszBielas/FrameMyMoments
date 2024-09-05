package com.frameMyMoments.frameMyMoments.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@AllArgsConstructor
@RequiredArgsConstructor
public class CartItemDTO {
    private Long id;
    private Long productId;
    private Long sessionId;
    private Long quantity;
}
