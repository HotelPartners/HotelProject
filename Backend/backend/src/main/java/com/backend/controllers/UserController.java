package com.backend.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.backend.config.JwtService;
import com.backend.dtos.LoginDTO;
import com.backend.dtos.UserDTO;
import com.backend.pojos.UserPOJO;
import com.backend.services.interfaces.IUserService;

@RestController
@RequestMapping("/users")
@CrossOrigin(origins = "*")
public class UserController {
    @Autowired
    private IUserService userService;

    @Autowired
    private JwtService jwtService; 
    

    @GetMapping("/allUsers")
    public List<UserDTO> allUsers(){
        return userService.allUsers();
    }

    @GetMapping("/all-customers")
    public List<UserDTO> allCustomers(){
    	System.out.println("*********");
        return userService.allCustomers();
    }
    @GetMapping("/{token}")
    public UserDTO userById(@PathVariable String token){
   	 String email=jwtService.extractUserName(token);
   	 return userService.userByEmail(email);
    }        
 
    

    @PutMapping("/update-user/{token}")
    public UserDTO updateUserProfile(@RequestBody UserDTO userDTO,@PathVariable String token)
    {
    	 String email=jwtService.extractUserName(token);
        return userService.updateUserProfile(userDTO, email); 
    } 
    
    @GetMapping("/is-user-valid/{token}")
    public ResponseEntity<String> IsUserValid(@PathVariable String token)
    {
    	String email = jwtService.extractUserName(token);
    	return userService.IsUserValid(email);
    }
} 
