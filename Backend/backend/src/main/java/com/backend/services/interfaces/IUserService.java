package com.backend.services.interfaces;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.backend.dtos.LoginDTO;
import com.backend.dtos.UserDTO;
import com.backend.pojos.UserPOJO;

public interface IUserService {
    UserPOJO addUser(UserDTO user);
    List<UserDTO> allUsers();
    UserDTO userByEmail(String userEmail);
    UserDTO userByEmailAndPassword(LoginDTO loginDTO);
    UserDTO updateUserProfile(UserDTO userDTO,String userEmail);
    public List<UserDTO> allCustomers() ;
	ResponseEntity<String> IsUserValid(String email);
}
   