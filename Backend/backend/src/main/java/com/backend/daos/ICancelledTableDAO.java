package com.backend.daos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.backend.pojos.CancelledTablePOJO;

public interface ICancelledTableDAO extends JpaRepository<CancelledTablePOJO,Long> {
    
}
