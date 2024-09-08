package com.frameMyMoments.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@AllArgsConstructor
@RequiredArgsConstructor
public class UserDetailDTO {
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
}
