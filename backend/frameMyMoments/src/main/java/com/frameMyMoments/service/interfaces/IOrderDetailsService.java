package com.frameMyMoments.service.interfaces;

import com.frameMyMoments.dto.OrderDetailsDTO;
import com.frameMyMoments.dto.OrderItemsDTO;

import java.util.List;

public interface IOrderDetailsService {
    OrderDetailsDTO getOrderDetailsById(Long id);
    OrderDetailsDTO createOrder(OrderDetailsDTO orderDetailsDTO);
    OrderDetailsDTO updateOrder(Long id, OrderDetailsDTO orderDetailsDTO);
    void deleteOrder(Long id);
    List<OrderDetailsDTO> getAllOrders();
    List<OrderItemsDTO> getOrderItemsByOrderId(Long orderId);
}
