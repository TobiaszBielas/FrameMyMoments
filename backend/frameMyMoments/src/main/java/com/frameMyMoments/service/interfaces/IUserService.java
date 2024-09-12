package com.frameMyMoments.service.interfaces;

import com.frameMyMoments.dto.UserDTO;

import java.util.List;

public interface IUserService {
    UserDTO getUserById(Long id);
    UserDTO createUser(UserDTO userDTO);
    UserDTO updateUser(Long id, UserDTO userDTO);
    void deleteUser(Long id);
    List<UserDTO> getAllUsers();
}
