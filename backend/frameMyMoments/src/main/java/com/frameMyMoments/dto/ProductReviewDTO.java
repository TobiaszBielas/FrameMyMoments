package com.frameMyMoments.dto;

import com.frameMyMoments.entity.Product;
import com.frameMyMoments.entity.ProductReview;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@AllArgsConstructor
@RequiredArgsConstructor
public class ProductReviewDTO {
    private Long id;
    private Long productId;
    private String review;

    public static ProductReviewDTO fromEntity(ProductReview productReview) {
        return new ProductReviewDTO(
                productReview.getId(),
                productReview.getProduct() != null ? productReview.getProduct().getId() : null,
                productReview.getReview()
        );
    }

    public static ProductReview toEntity(ProductReviewDTO productReviewDTO, Product product) {
        ProductReview productReview = new ProductReview();
        productReview.setId(productReviewDTO.getId());
        productReview.setProduct(product);
        productReview.setReview(productReviewDTO.getReview());
        return productReview;
    }
}
