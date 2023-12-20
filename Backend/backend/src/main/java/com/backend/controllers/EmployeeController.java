package com.backend.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.backend.dtos.EmployeeDTO;
import com.backend.dtos.EmployeeswithDeptDTO;
import com.backend.pojos.EmployeePOJO;
import com.backend.services.EmployeeService;






@RestController
@RequestMapping("/employee")
@CrossOrigin(origins = "*")
public class EmployeeController {
  
    @Autowired
    private EmployeeService employeeService;

  
    @PostMapping("/add-employee/{deptId}")
    public EmployeeDTO AddEmployee(@RequestBody EmployeeDTO employeeDTO,@PathVariable Long deptId)
    {
        return employeeService.AddEmployee(employeeDTO,deptId);
    }
    
    @GetMapping("/show-employees")
    public List<EmployeeswithDeptDTO> ShowAllEmployee()
    {
        return employeeService.ShowAllEmployee();
    }

    @GetMapping("/getEmployee/{empId}")
    public EmployeeswithDeptDTO getEmployee(@PathVariable Long empId)
    {
        return employeeService.getEmployee(empId);
    }

    @DeleteMapping("/delete-employee/{empid}")
    public String DeleteEmployee(@PathVariable Long empid)
    {
        return employeeService.DeleteEmployee(empid);
    }

    @PutMapping("/update-employee/{empId}")
    public String updateEmployeeDetails(@RequestBody EmployeeswithDeptDTO employeeswithDeptDTO,@PathVariable Long empId)
    {
        return employeeService.updateEmployeeDetails(employeeswithDeptDTO,empId);
    }
}