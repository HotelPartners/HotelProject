package com.backend.converters;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.backend.converters.interfaces.ISupplierConverter;
import com.backend.dtos.SupplierDTO;
import com.backend.pojos.SupplierPOJO;

@Component
public class SupplierConverter implements ISupplierConverter {

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public SupplierPOJO dtoToPojo(SupplierDTO supplierDTO) {
        return modelMapper.map(supplierDTO, SupplierPOJO.class);
    }

    @Override
    public List<SupplierPOJO> dtoToPojo(List<SupplierDTO> supplierDTOs) {
        return supplierDTOs.stream().map(x -> dtoToPojo(x)).collect(Collectors.toList());
    }

    @Override
    public SupplierDTO pojoToDto(SupplierPOJO supplierPOJO) {
        return modelMapper.map(supplierPOJO, SupplierDTO.class);
    }

    @Override
    public List<SupplierDTO> pojoToDto(List<SupplierPOJO> supplierPOJOs) {
        return supplierPOJOs.stream().map(x -> pojoToDto(x)).collect(Collectors.toList());
    }

}
