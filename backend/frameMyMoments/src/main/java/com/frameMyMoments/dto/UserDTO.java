package com.frameMyMoments.dto;

import com.frameMyMoments.entity.User;
import com.frameMyMoments.entity.UserRole;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@AllArgsConstructor
@RequiredArgsConstructor
public class UserDTO {
    private Long id;
    private Long userRoleId;
    private String username;
    private String email;
    private String password;

    public static UserDTO fromEntity(User user) {
        return new UserDTO(
                user.getId(),
                user.getUserRole() != null ? user.getUserRole().getId() : null,
                user.getUsername(),
                user.getEmail(),
                user.getPassword()
        );
    }

    public static User toEntity(UserDTO userDTO, UserRole userRole) {
        User user = new User();
        user.setId(userDTO.getId());
        user.setUsername(userDTO.getUsername());
        user.setEmail(userDTO.getEmail());
        user.setPassword(userDTO.getPassword());
        user.setUserRole(userRole);
        return user;
    }
}
