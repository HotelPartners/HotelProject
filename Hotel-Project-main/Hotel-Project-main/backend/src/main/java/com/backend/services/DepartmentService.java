package com.backend.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.backend.converters.DepartmentConverter;
import com.backend.daos.IDepartmentDAO;
import com.backend.daos.IEmployeeDao;
import com.backend.dtos.DepartmentDTO;
import com.backend.pojos.DepartmentPOJO;
import com.backend.services.interfaces.IDepartmentService;


@Transactional
@Service
public class DepartmentService implements IDepartmentService {

    @Autowired
    private IDepartmentDAO departmentDAO;

    @Autowired 
    private DepartmentConverter departmentConverter;


    @Override
    public DepartmentDTO AddDepartment(DepartmentDTO departmentDTO) {
        DepartmentPOJO departmentPojo=departmentConverter.dtoToPojo(departmentDTO);
        
        return departmentConverter.pojoToDto(departmentDAO.save(departmentPojo));
    }
    
}
