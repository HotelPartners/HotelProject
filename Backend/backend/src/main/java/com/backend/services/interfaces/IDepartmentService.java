package com.backend.services.interfaces;

import com.backend.dtos.DepartmentDTO;
import com.backend.pojos.DepartmentPOJO;

public interface IDepartmentService {
    public DepartmentDTO AddDepartment(DepartmentDTO departmentDTO);
}
