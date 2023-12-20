package com.backend.services.interfaces;

import java.util.List;

import com.backend.dtos.EmployeeDTO;
import com.backend.dtos.EmployeeswithDeptDTO;


public interface IEmployeeService {
    public EmployeeDTO AddEmployee(EmployeeDTO employeeDTO,Long deptId);
    public List<EmployeeswithDeptDTO> ShowAllEmployee();
    public String DeleteEmployee(Long empid);
    public EmployeeswithDeptDTO getEmployee(Long empId);
    public String updateEmployeeDetails(EmployeeswithDeptDTO employeeswithDeptDTO,Long empId);
}
