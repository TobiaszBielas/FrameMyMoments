package com.frameMyMoments.service.implementation;

import com.frameMyMoments.dto.CartItemDTO;
import com.frameMyMoments.entity.CartItem;
import com.frameMyMoments.entity.Product;
import com.frameMyMoments.entity.ShoppingSession;
import com.frameMyMoments.repository.CartItemRepository;
import com.frameMyMoments.repository.ProductsRepository;
import com.frameMyMoments.repository.ShoppingSessionRepository;
import com.frameMyMoments.service.interfaces.ICartItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CartItemService implements ICartItemService {

    @Autowired
    private CartItemRepository cartItemRepository;

    @Autowired
    private ProductsRepository productRepository;

    @Autowired
    private ShoppingSessionRepository shoppingSessionRepository;

    @Override
    public CartItemDTO getCartItemById(Long id) {
        CartItem cartItem = cartItemRepository.findById(id).orElseThrow(() -> new RuntimeException("CartItem not found"));
        return CartItemDTO.fromEntity(cartItem);
    }

    @Override
    public CartItemDTO createCartItem(CartItemDTO cartItemDTO) {
        Product product = productRepository.findById(cartItemDTO.getProductId())
                .orElseThrow(() -> new RuntimeException("Product not found"));
        ShoppingSession session = shoppingSessionRepository.findById(cartItemDTO.getSessionId())
                .orElseThrow(() -> new RuntimeException("Session not found"));
        CartItem cartItem = CartItemDTO.toEntity(cartItemDTO, product, session);
        cartItem = cartItemRepository.save(cartItem);
        return CartItemDTO.fromEntity(cartItem);
    }

    @Override
    public CartItemDTO updateCartItem(Long id, CartItemDTO cartItemDTO) {
        CartItem cartItem = cartItemRepository.findById(id).orElseThrow(() -> new RuntimeException("CartItem not found"));
        Product product = productRepository.findById(cartItemDTO.getProductId())
                .orElseThrow(() -> new RuntimeException("Product not found"));
        ShoppingSession session = shoppingSessionRepository.findById(cartItemDTO.getSessionId())
                .orElseThrow(() -> new RuntimeException("Session not found"));
        cartItem = CartItemDTO.toEntity(cartItemDTO, product, session);
        cartItem.setId(id);
        cartItem = cartItemRepository.save(cartItem);
        return CartItemDTO.fromEntity(cartItem);
    }

    @Override
    public void deleteCartItem(Long id) {
        cartItemRepository.deleteById(id);
    }

    @Override
    public List<CartItemDTO> getCartItemsBySessionId(Long sessionId) {
        List<CartItem> cartItems = cartItemRepository.findBySessionId(sessionId);
        return cartItems.stream().map(CartItemDTO::fromEntity).collect(Collectors.toList());
    }

    @Override
    public CartItemDTO addItemToCart(CartItemDTO cartItemDTO) {
        ShoppingSession shoppingSession = shoppingSessionRepository.findById(cartItemDTO.getSessionId())
                .orElseThrow(() -> new ResourceNotFoundException("Shopping session not found with id " + cartItemDTO.getSessionId()));

        Product product = productRepository.findById(cartItemDTO.getProductId())
                .orElseThrow(() -> new ResourceNotFoundException("Product not found with id " + cartItemDTO.getProductId()));

        CartItem cartItem = CartItem.builder()
                .product(product)
                .session(shoppingSession)
                .quantity(cartItemDTO.getQuantity())
                .build();

        CartItem savedCartItem = cartItemRepository.save(cartItem);

        return mapToDTO(savedCartItem);
    }

    private CartItemDTO mapToDTO(CartItem cartItem) {
        return CartItemDTO.builder()
                .id(cartItem.getId())
                .productId(cartItem.getProduct().getId())
                .sessionId(cartItem.getSession().getId())
                .quantity(cartItem.getQuantity())
                .build();
    }
}