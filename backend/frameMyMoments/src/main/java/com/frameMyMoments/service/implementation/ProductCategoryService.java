package com.frameMyMoments.service.implementation;

import com.frameMyMoments.dto.ProductCategoryDTO;
import com.frameMyMoments.entity.ProductCategory;
import com.frameMyMoments.repository.ProductCategoryRepository;
import com.frameMyMoments.service.interfaces.IProductCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductCategoryService implements IProductCategoryService {

    @Autowired
    private ProductCategoryRepository productCategoryRepository;

    @Override
    public ProductCategoryDTO getProductCategoryById(Long id) {
        ProductCategory productCategory = productCategoryRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("ProductCategory not found"));
        return ProductCategoryDTO.fromEntity(productCategory);
    }

    @Override
    public ProductCategoryDTO createProductCategory(ProductCategoryDTO productCategoryDTO) {
        ProductCategory productCategory = ProductCategoryDTO.toEntity(productCategoryDTO);
        productCategory = productCategoryRepository.save(productCategory);
        return ProductCategoryDTO.fromEntity(productCategory);
    }

    @Override
    public ProductCategoryDTO updateProductCategory(Long id, ProductCategoryDTO productCategoryDTO) {
        ProductCategory productCategory = productCategoryRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("ProductCategory not found"));
        productCategory = ProductCategoryDTO.toEntity(productCategoryDTO);
        productCategory.setId(id);
        productCategory = productCategoryRepository.save(productCategory);
        return ProductCategoryDTO.fromEntity(productCategory);
    }

    @Override
    public void deleteProductCategory(Long id) {
        productCategoryRepository.deleteById(id);
    }

    @Override
    public List<ProductCategoryDTO> getAllProductCategories() {
        List<ProductCategory> categories = productCategoryRepository.findAll();
        return categories.stream().map(ProductCategoryDTO::fromEntity).collect(Collectors.toList());
    }
}