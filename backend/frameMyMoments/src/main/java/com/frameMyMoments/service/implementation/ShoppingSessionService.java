package com.frameMyMoments.service.implementation;

import com.frameMyMoments.dto.ShoppingSessionDTO;
import com.frameMyMoments.entity.ShoppingSession;
import com.frameMyMoments.entity.User;
import com.frameMyMoments.repository.ShoppingSessionRepository;
import com.frameMyMoments.repository.UserRepository;
import com.frameMyMoments.service.interfaces.IShoppingSessionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ShoppingSessionService implements IShoppingSessionService {

    @Autowired
    private ShoppingSessionRepository shoppingSessionRepository;

    @Autowired
    private UserRepository userRepository;

    @Override
    public ShoppingSessionDTO getShoppingSessionById(Long id) {
        ShoppingSession shoppingSession = shoppingSessionRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("ShoppingSession not found"));
        return ShoppingSessionDTO.fromEntity(shoppingSession);
    }

    @Override
    public ShoppingSessionDTO createShoppingSession(ShoppingSessionDTO shoppingSessionDTO) {
        User user = userRepository.findById(shoppingSessionDTO.getUserId())
                .orElseThrow(() -> new RuntimeException("User not found"));
        ShoppingSession shoppingSession = ShoppingSessionDTO.toEntity(shoppingSessionDTO, user);
        shoppingSession = shoppingSessionRepository.save(shoppingSession);
        return ShoppingSessionDTO.fromEntity(shoppingSession);
    }

    @Override
    public ShoppingSessionDTO updateShoppingSession(Long id, ShoppingSessionDTO shoppingSessionDTO) {
        ShoppingSession shoppingSession = shoppingSessionRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("ShoppingSession not found"));
        User user = userRepository.findById(shoppingSessionDTO.getUserId())
                .orElseThrow(() -> new RuntimeException("User not found"));
        shoppingSession = ShoppingSessionDTO.toEntity(shoppingSessionDTO, user);
        shoppingSession.setId(id);
        shoppingSession = shoppingSessionRepository.save(shoppingSession);
        return ShoppingSessionDTO.fromEntity(shoppingSession);
    }

    @Override
    public void deleteShoppingSession(Long id) {
        shoppingSessionRepository.deleteById(id);
    }

    @Override
    public List<ShoppingSessionDTO> getAllShoppingSessions() {
        List<ShoppingSession> sessions = shoppingSessionRepository.findAll();
        return sessions.stream().map(ShoppingSessionDTO::fromEntity).collect(Collectors.toList());
    }

    @Override
    public Optional<ShoppingSession> getSessionByUserId(Long userId) {
        return shoppingSessionRepository.findByUserId(userId);
    }
}