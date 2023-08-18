package com.backend.services.interfaces;

import com.backend.dtos.AddressDTO;
import com.backend.pojos.AddressPOJO;

public interface IAddressService {
    
    AddressPOJO addAddress(AddressDTO address, Long userId);

}
