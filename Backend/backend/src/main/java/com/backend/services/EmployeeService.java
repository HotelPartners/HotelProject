package com.backend.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;

import com.backend.converters.EmplyeeConverter;
import com.backend.daos.IDepartmentDAO;
import com.backend.daos.IEmployeeDao;
import com.backend.dtos.EmployeeDTO;
import com.backend.dtos.EmployeeswithDeptDTO;
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

@Override
public List<EmployeeswithDeptDTO> ShowAllEmployee()
{
    List<EmployeePOJO> employeePOJO=employeeDao.findAll();
    List<EmployeeswithDeptDTO> employeeswithDeptDTO=new ArrayList<>();

    for (EmployeePOJO employeePOJO2 : employeePOJO) {
        
        EmployeeswithDeptDTO data=new EmployeeswithDeptDTO();
        data.setFirstName(employeePOJO2.getFirstName());
        data.setLastName(employeePOJO2.getLastName());
        data.setAddress(employeePOJO2.getAddress());
        data.setJoiningDate(employeePOJO2.getJoiningDate());
        data.setMobileNumber(employeePOJO2.getMobileNumber());
        data.setSalary(employeePOJO2.getSalary());
        data.setEmpid(employeePOJO2.getEmpid());
        data.setDepartment(employeePOJO2.getDepartment().getDeptName());
        
        employeeswithDeptDTO.add(data);
    }
   
    return employeeswithDeptDTO;
}

@Override
public String DeleteEmployee(Long empid)
{
    try{
        EmployeePOJO employeePOJO = employeeDao.findById(empid).get();
        employeePOJO.getDepartment().removeEmoloyees(employeePOJO);

        
        return "success";    
    }
    catch(Exception ex)
    {
        return "error";
    }
}

@Override
public EmployeeswithDeptDTO getEmployee(Long empId)
{
    EmployeePOJO employeePOJO2=employeeDao.findById(empId).get();
     EmployeeswithDeptDTO data=new EmployeeswithDeptDTO();
        data.setFirstName(employeePOJO2.getFirstName());
        data.setLastName(employeePOJO2.getLastName());
        data.setAddress(employeePOJO2.getAddress());
        data.setJoiningDate(employeePOJO2.getJoiningDate());
        data.setMobileNumber(employeePOJO2.getMobileNumber());
        data.setSalary(employeePOJO2.getSalary());
        data.setEmpid(employeePOJO2.getEmpid());
        data.setDepartment(employeePOJO2.getDepartment().getDeptName());
    return data;
}
    
@Override
public String updateEmployeeDetails(EmployeeswithDeptDTO employeeswithDeptDTO,Long empId)
{
    EmployeePOJO employeePOJO=employeeDao.findById(empId).get();
    employeePOJO.setFirstName(employeeswithDeptDTO.getFirstName());
    employeePOJO.setLastName(employeeswithDeptDTO.getLastName());
    employeePOJO.setAddress(employeeswithDeptDTO.getAddress());
    employeePOJO.setDepartment(departmentDAO.findByDeptName(employeeswithDeptDTO.getDepartment()));
    employeePOJO.setJoiningDate(employeeswithDeptDTO.getJoiningDate());
    employeePOJO.setMobileNumber(employeeswithDeptDTO.getMobileNumber());
    employeePOJO.setSalary(employeeswithDeptDTO.getSalary());
    employeeDao.save(employeePOJO);
    return "success";
}
    
}
