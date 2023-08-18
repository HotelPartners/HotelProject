package com.backend.daos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.backend.pojos.EmployeePOJO;

public interface IEmployeeDao extends JpaRepository<EmployeePOJO,Long>{
    
}
