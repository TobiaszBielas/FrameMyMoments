package com.frameMyMoments.frameMyMoments.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@AllArgsConstructor
@RequiredArgsConstructor
public class ProductCategoryDTO {
    private Long id;
    private String name;
}
