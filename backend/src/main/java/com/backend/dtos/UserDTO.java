package com.backend.dtos;

import java.util.List;

import com.backend.pojos.enums.UserRole;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserDTO {
    private Long userId;
    private String firstName;
    private String lastName;
    private UserRole role;
    private String userEmail;
    private String mobileNumber;
    private String password;
    private byte[] userImage;
}
