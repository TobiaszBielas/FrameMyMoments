package com.frameMyMoments.controller;

import com.frameMyMoments.dto.UserRoleDTO;
import com.frameMyMoments.service.interfaces.IUserRoleService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/user-roles")
@RequiredArgsConstructor
public class UserRoleController {

    private final IUserRoleService userRoleService;

    @GetMapping("/{id}")
    public ResponseEntity<UserRoleDTO> getRoleById(@PathVariable Long id) {
        UserRoleDTO role = userRoleService.getUserRoleById(id);
        return ResponseEntity.ok(role);
    }

    @PostMapping
    public ResponseEntity<UserRoleDTO> createRole(@RequestBody UserRoleDTO userRoleDTO) {
        UserRoleDTO newRole = userRoleService.createUserRole(userRoleDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(newRole);
    }
}