package com.frameMyMoments.dto;

import com.frameMyMoments.entity.UserRole;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserRoleDTO {
    private Long id;
    private String roleName;
    private String description;

    public static UserRoleDTO fromEntity(UserRole userRole) {
        return new UserRoleDTO(
                userRole.getId(),
                userRole.getRoleName(),
                userRole.getDescription()
        );
    }

    public static UserRole toEntity(UserRoleDTO userRoleDTO) {
        UserRole userRole = new UserRole();
        userRole.setId(userRoleDTO.getId());
        userRole.setRoleName(userRoleDTO.getRoleName());
        userRole.setDescription(userRoleDTO.getDescription());
        return userRole;
    }
}
