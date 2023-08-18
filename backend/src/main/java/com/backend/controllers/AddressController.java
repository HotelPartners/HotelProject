package com.backend.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.backend.dtos.AddressDTO;
import com.backend.pojos.AddressPOJO;
import com.backend.services.interfaces.IAddressService;

@RestController
@RequestMapping("/address")
public class AddressController {

    @Autowired
    private IAddressService addressService;

    @PostMapping("/{userId}")
    public AddressPOJO addAddress(@RequestBody AddressDTO address, @PathVariable Long userId){
        return addressService.addAddress(address, userId);
    }

}
