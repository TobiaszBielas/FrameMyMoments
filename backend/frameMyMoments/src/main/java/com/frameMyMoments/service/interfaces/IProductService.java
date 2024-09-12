package com.frameMyMoments.service.interfaces;

import com.frameMyMoments.dto.ProductDTO;

import java.util.List;

public interface IProductService {
    ProductDTO getProductById(Long id);
    ProductDTO createProduct(ProductDTO productDTO);
    ProductDTO updateProduct(Long id, ProductDTO productDTO);
    void deleteProduct(Long id);
    List<ProductDTO> getAllProducts();
}
