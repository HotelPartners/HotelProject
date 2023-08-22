package com.backend.daos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.backend.pojos.OrderPOJO;

public interface IOrderDAO extends JpaRepository<OrderPOJO, Long>{
    
}
