package com.frameMyMoments.controller;

import com.frameMyMoments.dto.ShoppingSessionDTO;
import com.frameMyMoments.entity.ShoppingSession;
import com.frameMyMoments.service.interfaces.IShoppingSessionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/sessions")
@RequiredArgsConstructor
public class ShoppingSessionController {

    private final IShoppingSessionService shoppingSessionService;

    @GetMapping("/{userId}")
    public ResponseEntity<ShoppingSessionDTO> getSessionByUserId(@PathVariable Long userId) {
        Optional<ShoppingSession> session = shoppingSessionService.getSessionByUserId(userId);
        if (session.isPresent()) {
            ShoppingSessionDTO dto = ShoppingSessionDTO.fromEntity(session.get());
            return ResponseEntity.ok(dto);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<ShoppingSessionDTO> createSession(@RequestBody ShoppingSessionDTO sessionDTO) {
        ShoppingSessionDTO newSession = shoppingSessionService.createShoppingSession(sessionDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(newSession);
    }

//    @PutMapping("/{id}")
//    public ResponseEntity<ShoppingSessionDTO> updateSession(@PathVariable Long id, @RequestBody ShoppingSessionDTO sessionDTO) {
//        ShoppingSessionDTO updatedSession = shoppingSessionService.updateSession(id, sessionDTO);
//        return ResponseEntity.ok(updatedSession);
//    }
//
//    @DeleteMapping("/{id}")
//    public ResponseEntity<Void> deleteSession(@PathVariable Long id) {
//        shoppingSessionService.deleteSession(id);
//        return ResponseEntity.noContent().build();
//    }
}