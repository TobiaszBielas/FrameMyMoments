package com.frameMyMoments.service.interfaces;

import com.frameMyMoments.dto.UserRoleDTO;

import java.util.List;

public interface IUserRoleService {
    UserRoleDTO getUserRoleById(Long id);
    UserRoleDTO createUserRole(UserRoleDTO userRoleDTO);
    UserRoleDTO updateUserRole(Long id, UserRoleDTO userRoleDTO);
    void deleteUserRole(Long id);
    List<UserRoleDTO> getAllUserRoles();
}
