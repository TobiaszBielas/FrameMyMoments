package com.frameMyMoments.controller;

import com.frameMyMoments.dto.OrderItemsDTO;
import com.frameMyMoments.service.interfaces.IOrderItemsService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/orderItems")
@RequiredArgsConstructor
public class OrderItemsController {

    private final IOrderItemsService orderItemsService;

//    @GetMapping("/order/{orderId}")
//    public ResponseEntity<List<OrderItemsDTO>> getItemsByOrderId(@PathVariable Long orderId) {
//        List<OrderItemsDTO> items = orderItemsService.getItemsByOrderId(orderId);
//        return ResponseEntity.ok(items);
//    }
//
//    @PostMapping
//    public ResponseEntity<OrderItemsDTO> addItemToOrder(@RequestBody OrderItemsDTO orderItemsDTO) {
//        OrderItemsDTO newItem = orderItemsService.addItemToOrder(orderItemsDTO);
//        return ResponseEntity.status(HttpStatus.CREATED).body(newItem);
//    }
//@PutMapping("/{id}")
//public ResponseEntity<OrderItemsDTO> updateOrderItem(@PathVariable Long id, @RequestBody OrderItemsDTO orderItemsDTO) {
//    OrderItemsDTO updatedItem = orderItemsService.updateOrderItem(id, orderItemsDTO);
//    return ResponseEntity.ok(updatedItem);
//}
//
//    @DeleteMapping("/{id}")
//    public ResponseEntity<Void> deleteOrderItem(@PathVariable Long id) {
//        orderItemsService.deleteOrderItem(id);
//        return ResponseEntity.noContent().build();
//    }
}