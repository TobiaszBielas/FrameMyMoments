package com.frameMyMoments.controller;

import com.frameMyMoments.dto.ProductReviewDTO;
import com.frameMyMoments.service.interfaces.IProductReviewService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/reviews")
@RequiredArgsConstructor
public class ProductReviewController {

    private final IProductReviewService productReviewService;

    @GetMapping("/product/{productId}")
    public ResponseEntity<List<ProductReviewDTO>> getReviewsByProductId(@PathVariable Long productId) {
        List<ProductReviewDTO> reviews = productReviewService.getReviewsByProductId(productId);
        return ResponseEntity.ok(reviews);
    }

    @PostMapping
    public ResponseEntity<ProductReviewDTO> createReview(@RequestBody ProductReviewDTO reviewDTO) {
        ProductReviewDTO newReview = productReviewService.createProductReview(reviewDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(newReview);
    }
//    @DeleteMapping("/{id}")
//    public ResponseEntity<Void> deleteReview(@PathVariable Long id) {
//        productReviewService.deleteReview(id);
//        return ResponseEntity.noContent().build();
//    }
}