package com.frameMyMoments.service.interfaces;

import com.frameMyMoments.dto.ProductCategoryDTO;

import java.util.List;

public interface IProductCategoryService {
    ProductCategoryDTO getProductCategoryById(Long id);
    ProductCategoryDTO createProductCategory(ProductCategoryDTO productCategoryDTO);
    ProductCategoryDTO updateProductCategory(Long id, ProductCategoryDTO productCategoryDTO);
    void deleteProductCategory(Long id);
    List<ProductCategoryDTO> getAllProductCategories();
}
