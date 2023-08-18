package com.backend.daos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.backend.pojos.TableTypePricePOJO;

public interface ITableTypePriceDAO extends JpaRepository<TableTypePricePOJO, Long>{
    
}
