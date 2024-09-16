package com.frameMyMoments.controller;

import com.frameMyMoments.dto.ProductSizeDTO;
import com.frameMyMoments.service.interfaces.IProductSizeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/product-sizes")
@RequiredArgsConstructor
public class ProductSizeController {

    private final IProductSizeService productSizeService;

    @GetMapping
    public ResponseEntity<List<ProductSizeDTO>> getAllSizes() {
        List<ProductSizeDTO> sizes = productSizeService.getAllProductSizes();
        return ResponseEntity.ok(sizes);
    }

    @PostMapping
    public ResponseEntity<ProductSizeDTO> createSize(@RequestBody ProductSizeDTO sizeDTO) {
        ProductSizeDTO newSize = productSizeService.createProductSize(sizeDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(newSize);
    }

//    @PutMapping("/{id}")
//    public ResponseEntity<ProductSizeDTO> updateSize(@PathVariable Long id, @RequestBody ProductSizeDTO sizeDTO) {
//        ProductSizeDTO updatedSize = productSizeService.updateSize(id, sizeDTO);
//        return ResponseEntity.ok(updatedSize);
//    }
//
//    @DeleteMapping("/{id}")
//    public ResponseEntity<Void> deleteSize(@PathVariable Long id) {
//        productSizeService.deleteSize(id);
//        return ResponseEntity.noContent().build();
//    }
}