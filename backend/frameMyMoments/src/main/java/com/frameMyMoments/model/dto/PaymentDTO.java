package com.frameMyMoments.model.dto;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@AllArgsConstructor
@RequiredArgsConstructor
public class PaymentDTO {
    private Long id;
    private float amount;
    private String provider;
    private LocalDateTime created;
    private LocalDateTime finished;
}
