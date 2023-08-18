package com.backend.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.backend.dtos.UserDTO;
import com.backend.pojos.UserPOJO;
import com.backend.services.interfaces.IUserService;

@RestController
@RequestMapping("/users")
// @CrossOrigin(origins = "http://localhost:3000")
public class UserController {
    @Autowired
    private IUserService userService;

    @PostMapping
    public UserPOJO addUser(@RequestBody UserDTO user){
        return userService.addUser(user);
    }

    @GetMapping("/allUsers")
    public List<UserDTO> allUsers(){
        return userService.allUsers();
    }

    @GetMapping("/{userId}")
    public UserDTO userById(@PathVariable Long userId){
        return userService.userById(userId);
    }
}
