package com.frameMyMoments.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@AllArgsConstructor
@RequiredArgsConstructor
public class ProductSizeDTO {
    private Long id;
    private float shape;
    private float height;
    private float width;
    private float diameter;
}
