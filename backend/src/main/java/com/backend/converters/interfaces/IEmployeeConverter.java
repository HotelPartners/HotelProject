package com.backend.converters.interfaces;

import java.util.List;

import com.backend.dtos.EmployeeDTO;

import com.backend.pojos.EmployeePOJO;


public interface IEmployeeConverter {
    
     public EmployeePOJO dtoToPojo(EmployeeDTO employeeDto);
   

    public List<EmployeePOJO> dtoToPojo(List<EmployeeDTO> employeeDto);

    public EmployeeDTO pojoToDto(EmployeePOJO employeePojo);

    public List<EmployeeDTO> pojoToDto(List<EmployeePOJO> employeePojo);
}
