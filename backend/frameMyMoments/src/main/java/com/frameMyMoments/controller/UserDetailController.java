package com.frameMyMoments.controller;

import com.frameMyMoments.dto.UserDetailsDTO;
import com.frameMyMoments.service.interfaces.IUserDetailsService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
@RequestMapping("/api/auth/details/")
public class UserDetailController {

    private final IUserDetailsService userDetailsService;

    @GetMapping("/{userId}")
    public ResponseEntity<UserDetailsDTO> getUserDetails(@PathVariable Long userId) {
        UserDetailsDTO userDetails = userDetailsService.getUserDetailsByUserId(userId);
        return ResponseEntity.ok(userDetails);
    }

    @PutMapping("/{userId}")
    public ResponseEntity<UserDetailsDTO> updateUserDetails(@PathVariable Long userId, @RequestBody UserDetailsDTO userDetailsDTO) {
        UserDetailsDTO updatedDetails = userDetailsService.updateUserDetails(userId, userDetailsDTO);
        return ResponseEntity.ok(updatedDetails);
    }
    @PostMapping
    public ResponseEntity<UserDetailsDTO> createUserDetails(@RequestBody UserDetailsDTO userDetailsDTO) {
        UserDetailsDTO newUserDetails = userDetailsService.createUserDetails(userDetailsDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(newUserDetails);
    }
}