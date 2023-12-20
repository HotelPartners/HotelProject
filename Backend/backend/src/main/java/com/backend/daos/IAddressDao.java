package com.backend.daos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.backend.pojos.AddressPOJO;

public interface IAddressDao extends JpaRepository<AddressPOJO, Long>{
    
}
