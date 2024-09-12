package com.frameMyMoments.service.implementation;

import com.frameMyMoments.dto.UserRoleDTO;
import com.frameMyMoments.entity.UserRole;
import com.frameMyMoments.repository.UserRoleRepository;
import com.frameMyMoments.service.interfaces.IUserRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserRoleService implements IUserRoleService {

    @Autowired
    private UserRoleRepository userRoleRepository;

    @Override
    public UserRoleDTO getUserRoleById(Long id) {
        UserRole userRole = userRoleRepository.findById(id).orElseThrow(() -> new RuntimeException("Role not found"));
        return UserRoleDTO.fromEntity(userRole);
    }

    @Override
    public UserRoleDTO createUserRole(UserRoleDTO userRoleDTO) {
        UserRole userRole = UserRoleDTO.toEntity(userRoleDTO);
        userRole = userRoleRepository.save(userRole);
        return UserRoleDTO.fromEntity(userRole);
    }

    @Override
    public UserRoleDTO updateUserRole(Long id, UserRoleDTO userRoleDTO) {
        UserRole userRole = userRoleRepository.findById(id).orElseThrow(() -> new RuntimeException("Role not found"));
        userRole = UserRoleDTO.toEntity(userRoleDTO);
        userRole.setId(id);
        userRole = userRoleRepository.save(userRole);
        return UserRoleDTO.fromEntity(userRole);
    }

    @Override
    public void deleteUserRole(Long id) {
        userRoleRepository.deleteById(id);
    }

    @Override
    public List<UserRoleDTO> getAllUserRoles() {
        List<UserRole> roles = userRoleRepository.findAll();
        return roles.stream().map(UserRoleDTO::fromEntity).collect(Collectors.toList());
    }
}
