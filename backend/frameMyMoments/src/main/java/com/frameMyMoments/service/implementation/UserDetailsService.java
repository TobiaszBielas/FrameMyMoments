package com.frameMyMoments.service.implementation;

import com.frameMyMoments.dto.UserDetailsDTO;
import com.frameMyMoments.entity.User;
import com.frameMyMoments.entity.UserDetails;
import com.frameMyMoments.repository.UserDetailsRepository;
import com.frameMyMoments.repository.UserRepository;
import com.frameMyMoments.service.interfaces.IUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
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

    @Override
    public UserDetailsDTO getUserDetailsByUserId(Long userId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("User not found with id " + userId));

        UserDetails userDetails = userDetailsRepository.findByUserId(userId)
                .orElseThrow(() -> new ResourceNotFoundException("UserDetails not found for user with id " + userId));

        return mapToDTO(userDetails);
    }

    private UserDetailsDTO mapToDTO(UserDetails userDetails) {
        return UserDetailsDTO.builder()
                .id(userDetails.getId())
                .userId(userDetails.getUser().getId())
                .firstName(userDetails.getFirstName())
                .lastName(userDetails.getLastName())
                .phoneNumber(userDetails.getPhoneNumber())
                .postalCode(userDetails.getPostalCode())
                .city(userDetails.getCity())
                .street(userDetails.getStreet())
                .houseNumber(userDetails.getHouseNumber())
                .flatNumber(userDetails.getFlatNumber())
                .build();
    }
}