package com.frameMyMoments.dto;

import com.frameMyMoments.entity.ProductSize;
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

    public static ProductSizeDTO fromEntity(ProductSize productSize) {
        return new ProductSizeDTO(
                productSize.getId(),
                productSize.getShape(),
                productSize.getHeight(),
                productSize.getWidth(),
                productSize.getDiameter()
        );
    }

    public static ProductSize toEntity(ProductSizeDTO productSizeDTO) {
        ProductSize productSize = new ProductSize();
        productSize.setId(productSizeDTO.getId());
        productSize.setShape(productSizeDTO.getShape());
        productSize.setHeight(productSizeDTO.getHeight());
        productSize.setWidth(productSizeDTO.getWidth());
        productSize.setDiameter(productSizeDTO.getDiameter());
        return productSize;
    }
}
