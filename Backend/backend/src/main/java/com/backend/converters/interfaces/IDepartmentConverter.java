package com.backend.converters.interfaces;

import java.util.List;

import com.backend.dtos.DepartmentDTO;
import com.backend.pojos.DepartmentPOJO;

public interface IDepartmentConverter {
    public DepartmentPOJO dtoToPojo(DepartmentDTO departmentDTO);

    public List<DepartmentPOJO> dtoToPojo(List<DepartmentDTO> departmentDTO);

    public DepartmentDTO pojoToDto(DepartmentPOJO departmentPOJO);

    public List<DepartmentDTO> pojoToDto(List<DepartmentPOJO> departmentPOJO);
}
