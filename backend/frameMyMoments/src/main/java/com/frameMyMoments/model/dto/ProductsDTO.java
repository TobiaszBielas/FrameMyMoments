package com.frameMyMoments.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@AllArgsConstructor
@RequiredArgsConstructor
public class ProductsDTO {
    private Long id;
    private Long categoryId;
    private Long sizeId;
    private String name;
    private String description;
    private Long quantity;
    private float price;
}
