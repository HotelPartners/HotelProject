package com.backend.daos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.backend.pojos.UserPOJO;

public interface IUserDAO extends JpaRepository<UserPOJO,Long>{
    
}
