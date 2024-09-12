package com.frameMyMoments.service.implementation;

import com.frameMyMoments.dto.ProductReviewDTO;
import com.frameMyMoments.entity.Product;
import com.frameMyMoments.entity.ProductReview;
import com.frameMyMoments.repository.ProductReviewRepository;
import com.frameMyMoments.repository.ProductsRepository;
import com.frameMyMoments.service.interfaces.IProductReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductReviewService implements IProductReviewService {

    @Autowired
    private ProductReviewRepository productReviewRepository;

    @Autowired
    private ProductsRepository productRepository;

    @Override
    public ProductReviewDTO getProductReviewById(Long id) {
        ProductReview productReview = productReviewRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("ProductReview not found"));
        return ProductReviewDTO.fromEntity(productReview);
    }

    @Override
    public ProductReviewDTO createProductReview(ProductReviewDTO productReviewDTO) {
        Product product = productRepository.findById(productReviewDTO.getProductId())
                .orElseThrow(() -> new RuntimeException("Product not found"));
        ProductReview productReview = ProductReviewDTO.toEntity(productReviewDTO, product);
        productReview = productReviewRepository.save(productReview);
        return ProductReviewDTO.fromEntity(productReview);
    }

    @Override
    public ProductReviewDTO updateProductReview(Long id, ProductReviewDTO productReviewDTO) {
        ProductReview productReview = productReviewRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("ProductReview not found"));
        Product product = productRepository.findById(productReviewDTO.getProductId())
                .orElseThrow(() -> new RuntimeException("Product not found"));
        productReview = ProductReviewDTO.toEntity(productReviewDTO, product);
        productReview.setId(id);
        productReview = productReviewRepository.save(productReview);
        return ProductReviewDTO.fromEntity(productReview);
    }

    @Override
    public void deleteProductReview(Long id) {
        productReviewRepository.deleteById(id);
    }

    @Override
    public List<ProductReviewDTO> getAllProductReviews() {
        List<ProductReview> reviews = productReviewRepository.findAll();
        return reviews.stream().map(ProductReviewDTO::fromEntity).collect(Collectors.toList());
    }
}