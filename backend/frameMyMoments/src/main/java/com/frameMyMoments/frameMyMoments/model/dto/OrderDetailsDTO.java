package com.frameMyMoments.frameMyMoments.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@AllArgsConstructor
@RequiredArgsConstructor
public class OrderDetailsDTO {
    private Long id;
    private Long userId;
    private Long paymentId;
    private float totalPrice;
}
