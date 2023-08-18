package com.backend.converters;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.backend.converters.interfaces.IEmployeeConverter;
import com.backend.dtos.EmployeeDTO;

import com.backend.pojos.EmployeePOJO;


@Component
public class EmplyeeConverter implements IEmployeeConverter {


      @Autowired
    private ModelMapper modelMapper;

    @Override
    public EmployeePOJO dtoToPojo(EmployeeDTO employeeDto) {
      return modelMapper.map(employeeDto, EmployeePOJO.class);
        
    }

    @Override
    public List<EmployeePOJO> dtoToPojo(List<EmployeeDTO> employeeDto) {
       return employeeDto.stream().map(x -> dtoToPojo(x)).collect(Collectors.toList());
    }

    @Override
    public EmployeeDTO pojoToDto(EmployeePOJO employeePojo) {
        return modelMapper.map(employeePojo,EmployeeDTO.class);
    }

    @Override
    public List<EmployeeDTO> pojoToDto(List<EmployeePOJO> employeePojo) {
        return employeePojo.stream().map(x -> pojoToDto(x)).collect(Collectors.toList());
    }
    
}
