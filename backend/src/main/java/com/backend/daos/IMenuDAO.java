package com.backend.daos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.backend.pojos.MenuPOJO;

public interface IMenuDAO extends JpaRepository<MenuPOJO, Long> {
    
}