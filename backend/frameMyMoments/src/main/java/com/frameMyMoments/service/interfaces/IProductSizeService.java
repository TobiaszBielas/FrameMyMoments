package com.frameMyMoments.service.interfaces;

import com.frameMyMoments.dto.ProductSizeDTO;

import java.util.List;

public interface IProductSizeService {
    ProductSizeDTO getProductSizeById(Long id);
    ProductSizeDTO createProductSize(ProductSizeDTO productSizeDTO);
    ProductSizeDTO updateProductSize(Long id, ProductSizeDTO productSizeDTO);
    void deleteProductSize(Long id);
    List<ProductSizeDTO> getAllProductSizes();
}
