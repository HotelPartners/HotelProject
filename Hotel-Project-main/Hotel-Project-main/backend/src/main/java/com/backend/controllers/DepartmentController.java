package com.backend.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.backend.dtos.DepartmentDTO;
import com.backend.services.DepartmentService;

@RestController
@RequestMapping("/department")
public class DepartmentController {
    
    @Autowired
    private DepartmentService departmentService;

    @PostMapping("/add-department")
    public DepartmentDTO AddDepartment(@RequestBody DepartmentDTO departmentDTO)
    {
        return departmentService.AddDepartment(departmentDTO);
    }
}
