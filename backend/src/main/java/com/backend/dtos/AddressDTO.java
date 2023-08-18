package com.backend.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AddressDTO {
    private Long addressId;
    private String addressLine;
    private String landmark;
    private String city;
    private String pincode;
}
