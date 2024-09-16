package com.frameMyMoments.dto;

import com.frameMyMoments.entity.CartItem;
import com.frameMyMoments.entity.ShoppingSession;
import com.frameMyMoments.entity.Product;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@RequiredArgsConstructor
public class CartItemDTO {
    private Long id;
    private Long productId;
    private Long sessionId;
    private Long quantity;

    public static CartItemDTO fromEntity(CartItem cartItem) {
        return new CartItemDTO(
                cartItem.getId(),
                cartItem.getProduct() != null ? cartItem.getProduct().getId() : null,
                cartItem.getSession() != null ? cartItem.getSession().getId() : null,
                cartItem.getQuantity()
        );
    }

    public static CartItem toEntity(CartItemDTO cartItemDTO, Product product, ShoppingSession session) {
        CartItem cartItem = new CartItem();
        cartItem.setId(cartItemDTO.getId());
        cartItem.setProduct(product);
        cartItem.setSession(session);
        cartItem.setQuantity(cartItemDTO.getQuantity());
        return cartItem;
    }
}
