package com.frameMyMoments.service.implementation;

import com.frameMyMoments.dto.OrderItemsDTO;
import com.frameMyMoments.entity.OrderDetails;
import com.frameMyMoments.entity.OrderItem;
import com.frameMyMoments.entity.Product;
import com.frameMyMoments.repository.OrderDetailsRepository;
import com.frameMyMoments.repository.OrderItemsRepository;
import com.frameMyMoments.repository.ProductsRepository;
import com.frameMyMoments.service.interfaces.IOrderItemsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class OrderItemsService implements IOrderItemsService {

    @Autowired
    private OrderItemsRepository orderItemRepository;

    @Autowired
    private ProductsRepository productRepository;

    @Autowired
    private OrderDetailsRepository orderDetailsRepository;

    @Override
    public OrderItemsDTO getOrderItemsById(Long id) {
        OrderItem orderItem = orderItemRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("OrderItem not found"));
        return OrderItemsDTO.fromEntity(orderItem);
    }

    @Override
    public OrderItemsDTO createOrderItems(OrderItemsDTO orderItemDTO) {
        Product product = productRepository.findById(orderItemDTO.getProductId())
                .orElseThrow(() -> new RuntimeException("Product not found"));
        OrderDetails orderDetails = orderDetailsRepository.findById(orderItemDTO.getOrderId())
                .orElseThrow(() -> new RuntimeException("Order not found"));
        OrderItem orderItem = OrderItemsDTO.toEntity(orderItemDTO, orderDetails, product);
        orderItem = orderItemRepository.save(orderItem);
        return OrderItemsDTO.fromEntity(orderItem);
    }

    @Override
    public OrderItemsDTO updateOrderItems(Long id, OrderItemsDTO orderItemDTO) {
        OrderItem orderItem = orderItemRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("OrderItem not found"));
        Product product = productRepository.findById(orderItemDTO.getProductId())
                .orElseThrow(() -> new RuntimeException("Product not found"));
        OrderDetails orderDetails = orderDetailsRepository.findById(orderItemDTO.getOrderId())
                .orElseThrow(() -> new RuntimeException("Order not found"));
        orderItem = OrderItemsDTO.toEntity(orderItemDTO, orderDetails, product);
        orderItem.setId(id);
        orderItem = orderItemRepository.save(orderItem);
        return OrderItemsDTO.fromEntity(orderItem);
    }

    @Override
    public void deleteOrderItems(Long id) {
        orderItemRepository.deleteById(id);
    }

    @Override
    public List<OrderItemsDTO> getAllOrderItems() {
        List<OrderItem> orderItems = orderItemRepository.findAll();
        return orderItems.stream().map(OrderItemsDTO::fromEntity).collect(Collectors.toList());
    }
}