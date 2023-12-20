package com.backend.daos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.backend.pojos.ShopPOJO;

public interface IShopDAO extends JpaRepository<ShopPOJO, Long>{
    
}
