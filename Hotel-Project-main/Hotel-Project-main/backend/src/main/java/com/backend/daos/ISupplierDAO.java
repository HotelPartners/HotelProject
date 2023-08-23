package com.backend.daos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.backend.pojos.SupplierPOJO;

public interface ISupplierDAO extends JpaRepository<SupplierPOJO, Long>{
    
}
