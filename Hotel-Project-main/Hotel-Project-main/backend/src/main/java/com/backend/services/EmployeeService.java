package com.backend.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.backend.converters.EmplyeeConverter;
import com.backend.daos.IDepartmentDAO;
import com.backend.daos.IEmployeeDao;
import com.backend.dtos.EmployeeDTO;
import com.backend.pojos.DepartmentPOJO;
import com.backend.pojos.EmployeePOJO;
import com.backend.services.interfaces.IEmployeeService;


@Service
@Transactional
public class EmployeeService implements IEmployeeService{

@Autowired
private IEmployeeDao employeeDao;

@Autowired
private EmplyeeConverter emplyeeConverter;

@Autowired
private IDepartmentDAO departmentDAO;


@Override
public EmployeeDTO AddEmployee(EmployeeDTO employeeDTO,Long deptId)
{
    DepartmentPOJO departmentPOJO=departmentDAO.findById(deptId).get();

    EmployeePOJO employeePOJO=emplyeeConverter.dtoToPojo(employeeDTO);
    employeePOJO=employeeDao.save(employeePOJO);
    departmentPOJO.addEmployees(employeePOJO);
    return emplyeeConverter.pojoToDto(employeePOJO);    
}

    
    
}
