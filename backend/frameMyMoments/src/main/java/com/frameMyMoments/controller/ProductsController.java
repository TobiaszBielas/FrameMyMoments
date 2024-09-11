package com.frameMyMoments.controller;

import com.frameMyMoments.dto.ProductDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
@RequestMapping("/api/product/")
public class ProductsController {
    @GetMapping("/all")
    public ResponseEntity<?> getAllProducts(){
        return null;
    }
//    @GetMapping("/test")
//    public String test(){
//        return "working";
//    }

    @GetMapping("/all/{id}")
    public ResponseEntity<?> getProduct(@PathVariable("id") Long productId){
        return null;
    }

    @GetMapping("/all/{id}/reviews")
    public ResponseEntity<?> getProductReviews(@PathVariable("id") Long productId){
        return null;
    }

    @PostMapping("/addProduct")
    public ResponseEntity<?> addProduct(@RequestBody ProductDTO products){
        return null;
    }

    @PostMapping("/updateProduct/{id}")
    public ResponseEntity<?> UpdateProduct(@RequestBody ProductDTO products, @PathVariable("id") Long productId){
        return null;
    }

    @PostMapping("/all/{id}/reviews")
    public ResponseEntity<?> addProductReviews(@PathVariable("id") Long productId){
        return null;
    }

    @DeleteMapping("/deleteProduct/{id}")
    public ResponseEntity<?> deleteProduct(@PathVariable("id") Long productId){
        return null;
    }
}
