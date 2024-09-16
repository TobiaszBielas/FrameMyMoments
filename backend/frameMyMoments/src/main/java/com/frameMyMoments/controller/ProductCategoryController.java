package com.frameMyMoments.controller;

import com.frameMyMoments.dto.ProductCategoryDTO;
import com.frameMyMoments.service.interfaces.IProductCategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/product-categories")
@RequiredArgsConstructor
public class ProductCategoryController {

    private final IProductCategoryService productCategoryService;

    @GetMapping
    public ResponseEntity<List<ProductCategoryDTO>> getAllCategories() {
        List<ProductCategoryDTO> categories = productCategoryService.getAllProductCategories();
        return ResponseEntity.ok(categories);
    }

    @PostMapping
    public ResponseEntity<ProductCategoryDTO> createCategory(@RequestBody ProductCategoryDTO categoryDTO) {
        ProductCategoryDTO newCategory = productCategoryService.createProductCategory(categoryDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(newCategory);
    }

//    @GetMapping("/{id}")
//    public ResponseEntity<ProductCategoryDTO> getCategoryById(@PathVariable Long id) {
//        ProductCategoryDTO category = productCategoryService.getCategoryById(id);
//        return ResponseEntity.ok(category);
//    }
//
//    @PutMapping("/{id}")
//    public ResponseEntity<ProductCategoryDTO> updateCategory(@PathVariable Long id, @RequestBody ProductCategoryDTO categoryDTO) {
//        ProductCategoryDTO updatedCategory = productCategoryService.updateCategory(id, categoryDTO);
//        return ResponseEntity.ok(updatedCategory);
//    }
//
//    @DeleteMapping("/{id}")
//    public ResponseEntity<Void> deleteCategory(@PathVariable Long id) {
//        productCategoryService.deleteCategory(id);
//        return ResponseEntity.noContent().build();
//    }
}
