package com.backend.daos;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.backend.pojos.UserPOJO;
import com.backend.pojos.enums.UserRole;


public interface IUserDAO extends JpaRepository<UserPOJO,Long>{
    UserPOJO findByUserEmailAndPassword(String userEmail, String password);
    List<UserPOJO> findByRole(UserRole s);
    Optional<UserPOJO> findByUserEmail(String userEmail);
}
