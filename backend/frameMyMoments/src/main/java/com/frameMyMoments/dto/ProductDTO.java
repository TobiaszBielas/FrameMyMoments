package com.frameMyMoments.dto;

import com.frameMyMoments.entity.Product;
import com.frameMyMoments.entity.ProductSize;
import com.frameMyMoments.entity.ProductCategory;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@RequiredArgsConstructor
public class ProductDTO {
    private Long id;
    private String imageUrl;

    private Long categoryId;
    private Long sizeId;
    private String name;
    private String description;
    private Long quantity;
    private BigDecimal price;

    public static ProductDTO fromEntity(Product product) {
        return new ProductDTO(
                product.getId(),
                product.getImageUrl(),
                product.getCategory() != null ? product.getCategory().getId() : null,
                product.getSize() != null ? product.getSize().getId() : null,
                product.getName(),
                product.getDescription(),
                product.getQuantity(),
                product.getPrice()
        );
    }

    public static Product toEntity(ProductDTO productDTO, ProductCategory category, ProductSize productSize) {
        Product product = new Product();
        product.setId(productDTO.getId());
        product.setImageUrl(productDTO.getImageUrl());
        product.setCategory(category);
        product.setSize(productSize);
        product.setName(productDTO.getName());
        product.setDescription(productDTO.getDescription());
        product.setQuantity(productDTO.getQuantity());
        product.setPrice(productDTO.getPrice());
        return product;
    }
}
