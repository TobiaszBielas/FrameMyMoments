package com.frameMyMoments.dto;

import com.frameMyMoments.entity.OrderDetails;
import com.frameMyMoments.entity.Payment;
import com.frameMyMoments.entity.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@RequiredArgsConstructor
public class OrderDetailsDTO {
    private Long id;
    private Long userId;
    private Long paymentId;
    private BigDecimal totalPrice;

    public static OrderDetailsDTO fromEntity(OrderDetails orderDetails) {
        return new OrderDetailsDTO(
                orderDetails.getId(),
                orderDetails.getUser() != null ? orderDetails.getUser().getId() : null,
                orderDetails.getPayment() != null ? orderDetails.getPayment().getId() : null,
                orderDetails.getTotalPrice()
        );
    }

    public static OrderDetails toEntity(OrderDetailsDTO orderDetailsDTO, User user, Payment payment) {
        OrderDetails orderDetails = new OrderDetails();
        orderDetails.setId(orderDetailsDTO.getId());
        orderDetails.setUser(user);
        orderDetails.setPayment(payment);
        orderDetails.setTotalPrice(orderDetailsDTO.getTotalPrice());
        return orderDetails;
    }
}
