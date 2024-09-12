package com.frameMyMoments.service.implementation;

import com.frameMyMoments.dto.ProductDTO;
import com.frameMyMoments.entity.Product;
import com.frameMyMoments.entity.ProductCategory;
import com.frameMyMoments.entity.ProductSize;
import com.frameMyMoments.repository.ProductCategoryRepository;
import com.frameMyMoments.repository.ProductSizeRepository;
import com.frameMyMoments.repository.ProductsRepository;
import com.frameMyMoments.service.interfaces.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductsService implements IProductService {

    @Autowired
    private ProductsRepository productRepository;

    @Autowired
    private ProductCategoryRepository productCategoryRepository;

    @Autowired
    private ProductSizeRepository productSizeRepository;

    @Override
    public ProductDTO getProductById(Long id) {
        Product product = productRepository.findById(id).orElseThrow(() -> new RuntimeException("Product not found"));
        return ProductDTO.fromEntity(product);
    }

    @Override
    public ProductDTO createProduct(ProductDTO productDTO) {
        ProductCategory category = productCategoryRepository.findById(productDTO.getCategoryId())
                .orElseThrow(() -> new RuntimeException("Category not found"));
        ProductSize productSize = productSizeRepository.findById(productDTO.getSizeId())
                .orElseThrow(() -> new RuntimeException("Size not found"));
        Product product = ProductDTO.toEntity(productDTO, category, productSize);
        product = productRepository.save(product);
        return ProductDTO.fromEntity(product);
    }

    @Override
    public ProductDTO updateProduct(Long id, ProductDTO productDTO) {
        Product product = productRepository.findById(id).orElseThrow(() -> new RuntimeException("Product not found"));
        ProductCategory category = productCategoryRepository.findById(productDTO.getCategoryId())
                .orElseThrow(() -> new RuntimeException("Category not found"));
        ProductSize productSize = productSizeRepository.findById(productDTO.getSizeId())
                .orElseThrow(() -> new RuntimeException("Size not found"));
        product = ProductDTO.toEntity(productDTO, category, productSize);
        product.setId(id);
        product = productRepository.save(product);
        return ProductDTO.fromEntity(product);
    }

    @Override
    public void deleteProduct(Long id) {
        productRepository.deleteById(id);
    }

    @Override
    public List<ProductDTO> getAllProducts() {
        List<Product> products = productRepository.findAll();
        return products.stream().map(ProductDTO::fromEntity).collect(Collectors.toList());
    }
}