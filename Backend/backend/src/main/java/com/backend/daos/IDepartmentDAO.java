package com.backend.daos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.backend.pojos.DepartmentPOJO;
import java.util.List;
import com.backend.pojos.EmployeePOJO;


public interface IDepartmentDAO extends JpaRepository<DepartmentPOJO,Long>{
  public DepartmentPOJO findByDeptName(String deptName);
}
