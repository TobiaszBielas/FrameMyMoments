package com.frameMyMoments.repository;

import com.frameMyMoments.entity.ShoppingSession;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ShoppingSessionRepository extends JpaRepository<ShoppingSession, Long> {
    Optional<ShoppingSession> findByUserId(Long userId);
}
