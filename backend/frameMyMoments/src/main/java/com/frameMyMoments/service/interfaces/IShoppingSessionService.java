package com.frameMyMoments.service.interfaces;

import com.frameMyMoments.dto.ShoppingSessionDTO;
import com.frameMyMoments.entity.ShoppingSession;

import java.util.List;
import java.util.Optional;

public interface IShoppingSessionService {
    ShoppingSessionDTO getShoppingSessionById(Long id);
    ShoppingSessionDTO createShoppingSession(ShoppingSessionDTO shoppingSessionDTO);
    ShoppingSessionDTO updateShoppingSession(Long id, ShoppingSessionDTO shoppingSessionDTO);
    void deleteShoppingSession(Long id);
    List<ShoppingSessionDTO> getAllShoppingSessions();
    Optional<ShoppingSession> getSessionByUserId(Long userId);
}
