package com.backend.daos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.backend.pojos.SupplierPOJO;
import java.util.List;


public interface ISupplierDAO extends JpaRepository<SupplierPOJO, Long>{
    SupplierPOJO findBySupplierName(String supplierName);
    // List<SupplierPOJO> findBySupplierName(String supplierName);
}
