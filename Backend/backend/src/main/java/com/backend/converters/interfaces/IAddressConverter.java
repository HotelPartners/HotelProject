package com.backend.converters.interfaces;

import java.util.List;

import com.backend.dtos.AddressDTO;
import com.backend.pojos.AddressPOJO;

public interface IAddressConverter {
    public AddressPOJO dtoToPojo(AddressDTO addressDTO);
    public List<AddressPOJO> dtoToPojo(List<AddressDTO> addressDTOs);
    public AddressDTO pojoToDto(AddressPOJO addressDTO);
    public List<AddressDTO> pojoToDto(List<AddressPOJO> addressDTOs);
}
