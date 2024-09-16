package com.frameMyMoments.service.interfaces;

import com.frameMyMoments.dto.ProductReviewDTO;

import java.util.List;

public interface IProductReviewService {
    ProductReviewDTO getProductReviewById(Long id);
    ProductReviewDTO createProductReview(ProductReviewDTO productReviewDTO);
    ProductReviewDTO updateProductReview(Long id, ProductReviewDTO productReviewDTO);
    void deleteProductReview(Long id);
    List<ProductReviewDTO> getAllProductReviews();

    List<ProductReviewDTO> getReviewsByProductId(Long productId);
}
