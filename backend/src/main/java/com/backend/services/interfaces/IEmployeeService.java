package com.backend.services.interfaces;

import java.util.List;

import com.backend.dtos.EmployeeDTO;
import com.backend.pojos.EmployeePOJO;

public interface IEmployeeService {
    public EmployeePOJO addEmployee(EmployeeDTO employeeDTO);

    public List<EmployeeDTO> allEmployees();
}
