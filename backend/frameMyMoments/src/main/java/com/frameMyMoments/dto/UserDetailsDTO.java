package com.frameMyMoments.dto;

import com.frameMyMoments.entity.User;
import com.frameMyMoments.entity.UserDetails;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@RequiredArgsConstructor
public class UserDetailsDTO {
    private Long id;
    private Long userId;
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String postalCode;
    private String city;
    private String street;
    private String houseNumber;
    private String flatNumber;

    public static UserDetailsDTO fromEntity(UserDetails userDetails) {
        return new UserDetailsDTO(
                userDetails.getId(),
                userDetails.getUser() != null ? userDetails.getUser().getId() : null,
                userDetails.getFirstName(),
                userDetails.getLastName(),
                userDetails.getPhoneNumber(),
                userDetails.getPostalCode(),
                userDetails.getCity(),
                userDetails.getStreet(),
                userDetails.getHouseNumber(),
                userDetails.getFlatNumber()
        );
    }

    public static UserDetails toEntity(UserDetailsDTO userDetailsDTO, User user) {
        UserDetails userDetails = new UserDetails();
        userDetails.setId(userDetailsDTO.getId());
        userDetails.setUser(user);
        userDetails.setFirstName(userDetailsDTO.getFirstName());
        userDetails.setLastName(userDetailsDTO.getLastName());
        userDetails.setPhoneNumber(userDetailsDTO.getPhoneNumber());
        userDetails.setPostalCode(userDetailsDTO.getPostalCode());
        userDetails.setCity(userDetailsDTO.getCity());
        userDetails.setStreet(userDetailsDTO.getStreet());
        userDetails.setHouseNumber(userDetailsDTO.getHouseNumber());
        userDetails.setFlatNumber(userDetailsDTO.getFlatNumber());
        return userDetails;
    }
}
