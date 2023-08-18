package com.backend.converters;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.backend.converters.interfaces.IAddressConverter;
import com.backend.dtos.AddressDTO;
import com.backend.pojos.AddressPOJO;

@Component
public class AddressConverter implements IAddressConverter{

    @Override
    public AddressPOJO dtoToPojo(AddressDTO addressDTO) {
        AddressPOJO addressPOJO = new AddressPOJO();
        addressPOJO.setAddressId(addressDTO.getAddressId());
        addressPOJO.setAddressLine(addressDTO.getAddressLine());
        addressPOJO.setCity(addressDTO.getCity());
        addressPOJO.setLandmark(addressDTO.getLandmark());
        addressPOJO.setPincode(addressDTO.getPincode());
        return addressPOJO;
    }

    @Override
    public List<AddressPOJO> dtoToPojo(List<AddressDTO> addressDTOs) {
        return addressDTOs.stream().map(x -> dtoToPojo(x)).collect(Collectors.toList());
    }

    @Override
    public AddressDTO pojoToDto(AddressPOJO addressPOJO) {
        AddressDTO addressDTO = new AddressDTO();
        addressDTO.setAddressId(addressPOJO.getAddressId());
        addressDTO.setAddressLine(addressPOJO.getAddressLine());
        addressDTO.setCity(addressPOJO.getCity());
        addressDTO.setLandmark(addressPOJO.getLandmark());
        addressDTO.setPincode(addressPOJO.getPincode());
        return addressDTO;
    }

    @Override
    public List<AddressDTO> pojoToDto(List<AddressPOJO> addressDTOs) {
        return addressDTOs.stream().map(x -> pojoToDto(x)).collect(Collectors.toList());
    }
    
}
