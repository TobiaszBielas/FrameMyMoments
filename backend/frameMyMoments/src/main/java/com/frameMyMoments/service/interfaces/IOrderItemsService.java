package com.frameMyMoments.service.interfaces;

import com.frameMyMoments.dto.OrderItemsDTO;

import java.util.List;

public interface IOrderItemsService {
    OrderItemsDTO getOrderItemsById(Long id);
    OrderItemsDTO createOrderItems(OrderItemsDTO orderItemsDTO);
    OrderItemsDTO updateOrderItems(Long id, OrderItemsDTO orderItemsDTO);
    void deleteOrderItems(Long id);
    List<OrderItemsDTO> getAllOrderItems();
}
