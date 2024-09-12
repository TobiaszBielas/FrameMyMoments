package com.frameMyMoments.service.implementation;

import com.frameMyMoments.dto.UserDetailsDTO;
import com.frameMyMoments.entity.User;
import com.frameMyMoments.entity.UserDetails;
import com.frameMyMoments.repository.UserDetailsRepository;
import com.frameMyMoments.repository.UserRepository;
import com.frameMyMoments.service.interfaces.IUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserDetailsService implements IUserDetailsService {

    @Autowired
    private UserDetailsRepository userDetailsRepository;

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetailsDTO getUserDetailsById(Long id) {
        UserDetails userDetails = userDetailsRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("UserDetails not found"));
        return UserDetailsDTO.fromEntity(userDetails);
    }

    @Override
    public UserDetailsDTO createUserDetails(UserDetailsDTO userDetailsDTO) {
        User user = userRepository.findById(userDetailsDTO.getUserId())
                .orElseThrow(() -> new RuntimeException("User not found"));
        UserDetails userDetails = UserDetailsDTO.toEntity(userDetailsDTO, user);
        userDetails = userDetailsRepository.save(userDetails);
        return UserDetailsDTO.fromEntity(userDetails);
    }

    @Override
    public UserDetailsDTO updateUserDetails(Long id, UserDetailsDTO userDetailsDTO) {
        UserDetails userDetails = userDetailsRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("UserDetails not found"));
        User user = userRepository.findById(userDetailsDTO.getUserId())
                .orElseThrow(() -> new RuntimeException("User not found"));
        userDetails = UserDetailsDTO.toEntity(userDetailsDTO, user);
        userDetails.setId(id);
        userDetails = userDetailsRepository.save(userDetails);
        return UserDetailsDTO.fromEntity(userDetails);
    }

    @Override
    public void deleteUserDetails(Long id) {
        userDetailsRepository.deleteById(id);
    }

    @Override
    public List<UserDetailsDTO> getAllUserDetails() {
        List<UserDetails> userDetailsList = userDetailsRepository.findAll();
        return userDetailsList.stream().map(UserDetailsDTO::fromEntity).collect(Collectors.toList());
    }
}