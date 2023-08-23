package com.backend.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.backend.dtos.EmployeeDTO;

import com.backend.services.EmployeeService;






@RestController
@RequestMapping("/Emplyee_Controller")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

  
    @PostMapping("/add-employee")
    public EmployeeDTO AddEmployee(@RequestBody EmployeeDTO employeeDTO,Long deptId)
    {
        return employeeService.AddEmployee(employeeDTO,deptId);
    }
    
}