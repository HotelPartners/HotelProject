package com.backend.daos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.backend.pojos.TablePOJO;

public interface ITableDAO extends JpaRepository<TablePOJO, Long>{
    
}
