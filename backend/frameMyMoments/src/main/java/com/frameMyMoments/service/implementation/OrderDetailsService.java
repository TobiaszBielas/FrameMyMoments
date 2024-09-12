package com.frameMyMoments.service.implementation;

import com.frameMyMoments.dto.OrderDetailsDTO;
import com.frameMyMoments.dto.OrderItemsDTO;
import com.frameMyMoments.entity.OrderDetails;
import com.frameMyMoments.entity.OrderItem;
import com.frameMyMoments.entity.Payment;
import com.frameMyMoments.entity.User;
import com.frameMyMoments.repository.OrderDetailsRepository;
import com.frameMyMoments.repository.OrderItemsRepository;
import com.frameMyMoments.repository.PaymentRepository;
import com.frameMyMoments.repository.UserRepository;
import com.frameMyMoments.service.interfaces.IOrderDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class OrderDetailsService implements IOrderDetailsService {

    @Autowired
    private OrderDetailsRepository orderDetailsRepository;

    @Autowired
    private OrderItemsRepository orderItemRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PaymentRepository paymentRepository;

    @Override
    public OrderDetailsDTO getOrderDetailsById(Long id) {
        OrderDetails orderDetails = orderDetailsRepository.findById(id).orElseThrow(() -> new RuntimeException("OrderDetails not found"));
        return OrderDetailsDTO.fromEntity(orderDetails);
    }

    @Override
    public OrderDetailsDTO createOrder(OrderDetailsDTO orderDetailsDTO) {
        User user = userRepository.findById(orderDetailsDTO.getUserId())
                .orElseThrow(() -> new RuntimeException("User not found"));
        Payment payment = paymentRepository.findById(orderDetailsDTO.getPaymentId())
                .orElseThrow(() -> new RuntimeException("Payment not found"));
        OrderDetails orderDetails = OrderDetailsDTO.toEntity(orderDetailsDTO, user, payment);
        orderDetails = orderDetailsRepository.save(orderDetails);
        return OrderDetailsDTO.fromEntity(orderDetails);
    }

    @Override
    public OrderDetailsDTO updateOrder(Long id, OrderDetailsDTO orderDetailsDTO) {
        OrderDetails orderDetails = orderDetailsRepository.findById(id).orElseThrow(() -> new RuntimeException("OrderDetails not found"));
        User user = userRepository.findById(orderDetailsDTO.getUserId())
                .orElseThrow(() -> new RuntimeException("User not found"));
        Payment payment = paymentRepository.findById(orderDetailsDTO.getPaymentId())
                .orElseThrow(() -> new RuntimeException("Payment not found"));
        orderDetails = OrderDetailsDTO.toEntity(orderDetailsDTO, user, payment);
        orderDetails.setId(id);
        orderDetails = orderDetailsRepository.save(orderDetails);
        return OrderDetailsDTO.fromEntity(orderDetails);
    }

    @Override
    public void deleteOrder(Long id) {
        orderDetailsRepository.deleteById(id);
    }

    @Override
    public List<OrderDetailsDTO> getAllOrders() {
        List<OrderDetails> orders = orderDetailsRepository.findAll();
        return orders.stream().map(OrderDetailsDTO::fromEntity).collect(Collectors.toList());
    }

    @Override
    public List<OrderItemsDTO> getOrderItemsByOrderId(Long orderId) {
        List<OrderItem> orderItems = orderItemRepository.findByOrderDetailsId(orderId);
        return orderItems.stream().map(OrderItemsDTO::fromEntity).collect(Collectors.toList());
    }
}