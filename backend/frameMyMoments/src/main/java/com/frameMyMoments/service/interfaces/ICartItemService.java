package com.frameMyMoments.service.interfaces;

import com.frameMyMoments.dto.CartItemDTO;

import java.util.List;

public interface ICartItemService {
    CartItemDTO getCartItemById(Long id);
    CartItemDTO createCartItem(CartItemDTO cartItemDTO);
    CartItemDTO updateCartItem(Long id, CartItemDTO cartItemDTO);
    void deleteCartItem(Long id);
    List<CartItemDTO> getCartItemsBySessionId(Long sessionId);
}
