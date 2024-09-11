package com.frameMyMoments.dto;

import com.frameMyMoments.entity.ProductCategory;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@AllArgsConstructor
@RequiredArgsConstructor
public class ProductCategoryDTO {
    private Long id;
    private String name;

    public static ProductCategoryDTO fromEntity(ProductCategory productCategory) {
        return new ProductCategoryDTO(
                productCategory.getId(),
                productCategory.getName()
        );
    }

    public static ProductCategory toEntity(ProductCategoryDTO productCategoryDTO) {
        ProductCategory productCategory = new ProductCategory();
        productCategory.setId(productCategoryDTO.getId());
        productCategory.setName(productCategoryDTO.getName());
        return productCategory;
    }
}
