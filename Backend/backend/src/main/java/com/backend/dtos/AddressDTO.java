package com.backend.dtos;

import org.springframework.stereotype.Component;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Component
public class AddressDTO {
    private Long addressId;
    private String addressLine;
    private String landmark;
    private String city;
    private String pincode;
}
