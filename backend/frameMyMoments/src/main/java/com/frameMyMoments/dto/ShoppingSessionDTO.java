package com.frameMyMoments.dto;

import com.frameMyMoments.entity.ShoppingSession;
import com.frameMyMoments.entity.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@RequiredArgsConstructor
public class ShoppingSessionDTO {
    private Long id;
    private Long userId;
//    private boolean status;
    private BigDecimal totalPrice;

    public static ShoppingSessionDTO fromEntity(ShoppingSession shoppingSession) {
        return new ShoppingSessionDTO(
                shoppingSession.getId(),
                shoppingSession.getUser() != null ? shoppingSession.getUser().getId() : null,
                shoppingSession.getTotalPrice()
        );
    }

    public static ShoppingSession toEntity(ShoppingSessionDTO shoppingSessionDTO, User user) {
        ShoppingSession shoppingSession = new ShoppingSession();
        shoppingSession.setId(shoppingSessionDTO.getId());
        shoppingSession.setUser(user);
        shoppingSession.setTotalPrice(shoppingSessionDTO.getTotalPrice());
        return shoppingSession;
    }
}
