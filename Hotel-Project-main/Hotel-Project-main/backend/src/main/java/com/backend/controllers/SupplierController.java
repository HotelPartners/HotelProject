package com.backend.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.backend.dtos.SupplierDTO;
import com.backend.services.interfaces.ISupplierService;

@RestController
@RequestMapping("/supplier")
public class SupplierController {
    @Autowired
    private ISupplierService supplierService;

    @PostMapping("/{shopId}")
    public ResponseEntity<?> addSupplier(@RequestBody SupplierDTO supplierDTO, @PathVariable Long shopId){
        return ResponseEntity.status(HttpStatus.OK).body(supplierService.addSupplier(supplierDTO, shopId));
    }
}
