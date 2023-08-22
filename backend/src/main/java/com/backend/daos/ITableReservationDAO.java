package com.backend.daos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.backend.pojos.TableReservationPOJO;

public interface ITableReservationDAO extends JpaRepository<TableReservationPOJO,Long> {
    
}
