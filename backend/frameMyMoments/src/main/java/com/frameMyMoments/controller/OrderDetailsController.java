package com.frameMyMoments.controller;

import com.frameMyMoments.dto.OrderDetailsDTO;
import com.frameMyMoments.service.interfaces.IOrderDetailsService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
@RequestMapping("/api/orderDetails/")
public class OrderDetailsController {

    private final IOrderDetailsService orderDetailsService;

    @GetMapping
    public ResponseEntity<List<OrderDetailsDTO>> getAllOrders() {
        List<OrderDetailsDTO> orders = orderDetailsService.getAllOrders();
        return ResponseEntity.ok(orders);
    }

    @GetMapping("/{id}")
    public ResponseEntity<OrderDetailsDTO> getOrderById(@PathVariable Long id) {
        OrderDetailsDTO order = orderDetailsService.getOrderDetailsById(id);
        return ResponseEntity.ok(order);
    }

    @PostMapping
    public ResponseEntity<OrderDetailsDTO> createOrder(@RequestBody OrderDetailsDTO orderDetailsDTO) {
        OrderDetailsDTO newOrder = orderDetailsService.createOrder(orderDetailsDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(newOrder);
    }

    @PutMapping("/{id}")
    public ResponseEntity<OrderDetailsDTO> updateOrder(@PathVariable Long id, @RequestBody OrderDetailsDTO orderDetailsDTO) {
        OrderDetailsDTO updatedOrder = orderDetailsService.updateOrder(id, orderDetailsDTO);
        return ResponseEntity.ok(updatedOrder);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteOrder(@PathVariable Long id) {
        orderDetailsService.deleteOrder(id);
        return ResponseEntity.noContent().build();
    }
}
