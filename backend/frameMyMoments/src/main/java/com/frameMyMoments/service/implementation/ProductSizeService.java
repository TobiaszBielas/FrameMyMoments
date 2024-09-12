package com.frameMyMoments.service.implementation;

import com.frameMyMoments.dto.ProductSizeDTO;
import com.frameMyMoments.entity.ProductSize;
import com.frameMyMoments.repository.ProductSizeRepository;
import com.frameMyMoments.service.interfaces.IProductSizeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductSizeService implements IProductSizeService {

    @Autowired
    private ProductSizeRepository productSizeRepository;

    @Override
    public ProductSizeDTO getProductSizeById(Long id) {
        ProductSize productSize = productSizeRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("ProductSize not found"));
        return ProductSizeDTO.fromEntity(productSize);
    }

    @Override
    public ProductSizeDTO createProductSize(ProductSizeDTO productSizeDTO) {
        ProductSize productSize = ProductSizeDTO.toEntity(productSizeDTO);
        productSize = productSizeRepository.save(productSize);
        return ProductSizeDTO.fromEntity(productSize);
    }

    @Override
    public ProductSizeDTO updateProductSize(Long id, ProductSizeDTO productSizeDTO) {
        ProductSize productSize = productSizeRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("ProductSize not found"));
        productSize = ProductSizeDTO.toEntity(productSizeDTO);
        productSize.setId(id);
        productSize = productSizeRepository.save(productSize);
        return ProductSizeDTO.fromEntity(productSize);
    }

    @Override
    public void deleteProductSize(Long id) {
        productSizeRepository.deleteById(id);
    }

    @Override
    public List<ProductSizeDTO> getAllProductSizes() {
        List<ProductSize> sizes = productSizeRepository.findAll();
        return sizes.stream().map(ProductSizeDTO::fromEntity).collect(Collectors.toList());
    }
}
