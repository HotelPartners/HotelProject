package com.backend.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.backend.config.JwtService;
import com.backend.dtos.AddressDTO;
import com.backend.services.interfaces.IAddressService;

@RestController
@RequestMapping("/address")
@CrossOrigin(origins = "*")
public class AddressController {

    @Autowired
    private IAddressService addressService;
    
    @Autowired
    private JwtService jwtService; 


    @PostMapping("/{token}")
    public ResponseEntity<?> addAddress(@RequestBody AddressDTO address,@PathVariable String token){
        String email=jwtService.extractUserName(token);
    	return ResponseEntity.status(HttpStatus.OK).body(addressService.addAddress(address, email));
    }

    @GetMapping("/get-address/{token}")
    public List<AddressDTO> getAddressById(@PathVariable String token)
    {
        String email=jwtService.extractUserName(token);
        return addressService.getAddress(email);
    }
}
