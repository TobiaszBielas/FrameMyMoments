package com.frameMyMoments.repository;

import com.frameMyMoments.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductsRepository extends JpaRepository<Product, Long> {
    List<Product> findAllByCategoryId(Long categoryId);
    List<Product> findByNameContaining(String name);
    List<Product> findByQuantityGreaterThan(Long quantity);

}
