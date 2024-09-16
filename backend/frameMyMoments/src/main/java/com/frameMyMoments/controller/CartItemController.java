package com.frameMyMoments.controller;

import com.frameMyMoments.dto.CartItemDTO;
import com.frameMyMoments.service.interfaces.ICartItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
@RequestMapping("/api/cart/")
public class CartItemController {

    private final ICartItemService cartItemService;

    @GetMapping("/session/{sessionId}")
    public ResponseEntity<List<CartItemDTO>> getItemsBySessionId(@PathVariable Long sessionId) {
        List<CartItemDTO> items = cartItemService.getCartItemsBySessionId(sessionId);
        return ResponseEntity.ok(items);
    }

    @PostMapping
    public ResponseEntity<CartItemDTO> addItemToCart(@RequestBody CartItemDTO cartItemDTO) {
        CartItemDTO newItem = cartItemService.addItemToCart(cartItemDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(newItem);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CartItemDTO> updateCartItem(@PathVariable Long id, @RequestBody CartItemDTO cartItemDTO) {
        CartItemDTO updatedItem = cartItemService.updateCartItem(id, cartItemDTO);
        return ResponseEntity.ok(updatedItem);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCartItem(@PathVariable Long id) {
        cartItemService.deleteCartItem(id);
        return ResponseEntity.noContent().build();
    }
}