package com.backend.daos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.backend.pojos.DepartmentPOJO;

public interface IDepartmentDAO extends JpaRepository<DepartmentPOJO,Long>{
    
}
