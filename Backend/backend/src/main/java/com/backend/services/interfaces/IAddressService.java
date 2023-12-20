package com.backend.services.interfaces;

import java.util.List;
import java.util.Set;



import com.backend.dtos.AddressDTO;

public interface IAddressService {
    
    List<AddressDTO> getAddress(String userEmail);
    AddressDTO addAddress(AddressDTO address, String userEmail);

}
