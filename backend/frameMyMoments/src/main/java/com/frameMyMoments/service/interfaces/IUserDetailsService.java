package com.frameMyMoments.service.interfaces;

import com.frameMyMoments.dto.UserDetailsDTO;

import java.util.List;

public interface IUserDetailsService {
    UserDetailsDTO getUserDetailsById(Long id);
    UserDetailsDTO createUserDetails(UserDetailsDTO userDetailsDTO);
    UserDetailsDTO updateUserDetails(Long id, UserDetailsDTO userDetailsDTO);
    void deleteUserDetails(Long id);
    List<UserDetailsDTO> getAllUserDetails();

    UserDetailsDTO getUserDetailsByUserId(Long userId);
}
