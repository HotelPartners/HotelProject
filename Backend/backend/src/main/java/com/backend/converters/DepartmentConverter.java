package com.backend.converters;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.backend.converters.interfaces.IDepartmentConverter;
import com.backend.dtos.DepartmentDTO;
import com.backend.pojos.DepartmentPOJO;

@Component
public class DepartmentConverter implements IDepartmentConverter{

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public DepartmentPOJO dtoToPojo(DepartmentDTO departmentDTO) {
        return modelMapper.map(departmentDTO,DepartmentPOJO.class);
    }

    @Override
    public List<DepartmentPOJO> dtoToPojo(List<DepartmentDTO> departmentDTO) {
        return departmentDTO.stream().map(x->dtoToPojo(x)).collect(Collectors.toList());
    }

    @Override
    public DepartmentDTO pojoToDto(DepartmentPOJO departmentPOJO) {
      return modelMapper.map(departmentPOJO,DepartmentDTO.class);
    }

    @Override
    public List<DepartmentDTO> pojoToDto(List<DepartmentPOJO> departmentPOJO) {
        return departmentPOJO.stream().map(x->pojoToDto(x)).collect(Collectors.toList());
    }
    
}
