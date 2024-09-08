package com.frameMyMoments.model.dao;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.*;

@Entity
@Table(name = "USER_DETAILS")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @OneToOne()
    @JoinColumn()
    @JsonProperty()
    private User user;
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String postalCode;
    private String city;
    private String street;
    private String houseNumber;
    private String flatNumber;
}
