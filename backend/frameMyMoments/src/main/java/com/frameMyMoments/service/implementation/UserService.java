package com.frameMyMoments.service.implementation;

import com.frameMyMoments.dto.UserDTO;
import com.frameMyMoments.entity.User;
import com.frameMyMoments.entity.UserRole;
import com.frameMyMoments.repository.UserRepository;
import com.frameMyMoments.repository.UserRoleRepository;
import com.frameMyMoments.service.interfaces.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService implements IUserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserRoleRepository userRoleRepository;

    @Override
    public UserDTO getUserById(Long id) {
        User user = userRepository.findById(id).orElseThrow(() -> new RuntimeException("User not found"));
        return UserDTO.fromEntity(user);
    }

    @Override
    public UserDTO createUser(UserDTO userDTO) {
        UserRole userRole = userRoleRepository.findById(userDTO.getUserRoleId())
                .orElseThrow(() -> new RuntimeException("Role not found"));
        User user = UserDTO.toEntity(userDTO, userRole);
        user = userRepository.save(user);
        return UserDTO.fromEntity(user);
    }

    @Override
    public UserDTO updateUser(Long id, UserDTO userDTO) {
        User user = userRepository.findById(id).orElseThrow(() -> new RuntimeException("User not found"));
        UserRole userRole = userRoleRepository.findById(userDTO.getUserRoleId())
                .orElseThrow(() -> new RuntimeException("Role not found"));
        user = UserDTO.toEntity(userDTO, userRole);
        user.setId(id);
        user = userRepository.save(user);
        return UserDTO.fromEntity(user);
    }

    @Override
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }

    @Override
    public List<UserDTO> getAllUsers() {
        List<User> users = userRepository.findAll();
        return users.stream().map(UserDTO::fromEntity).collect(Collectors.toList());
    }

}