package com.backend.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.backend.converters.EmplyeeConverter;
import com.backend.daos.IEmployeeDao;
import com.backend.dtos.EmployeeDTO;
import com.backend.pojos.EmployeePOJO;
import com.backend.services.interfaces.IEmployeeService;


@Service
@Transactional
public class EmployeeService implements IEmployeeService{

@Autowired
private IEmployeeDao employeeDao;

@Autowired
private EmplyeeConverter emplyeeConverter;

    @Override
    public EmployeePOJO addEmployee(EmployeeDTO employeeDTO) {
        
      return employeeDao.save(emplyeeConverter.dtoToPojo(employeeDTO));
    }

    @Override
    public List<EmployeeDTO> allEmployees() {
       return emplyeeConverter.pojoToDto(employeeDao.findAll());
    }

    
    
}
