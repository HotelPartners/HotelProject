package com.backend.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.backend.dtos.SupplierDTO;
import com.backend.dtos.UserDTO;
import com.backend.services.interfaces.ISupplierService;

@RestController
@RequestMapping("/supplier")
@CrossOrigin(origins = "*")
public class SupplierController {
    @Autowired
    private ISupplierService supplierService;

    @PostMapping("/addsupplier")
    public ResponseEntity<?> addSupplier(@RequestBody SupplierDTO supplierDTO){
        return ResponseEntity.status(HttpStatus.OK).body(supplierService.addSupplier(supplierDTO));
    }

    @GetMapping("/allsuppliers")
    public List<SupplierDTO> allSuppliers(){
        return supplierService.allSuppliers(); 
    }

    @DeleteMapping("/deletesupplier/{supplierid}")
    public String deleteSupplier(@PathVariable Long supplierid)
    {
        return supplierService.deleteSupplier(supplierid);
    }

    @GetMapping("/edit/{supplierId}")
    public SupplierDTO editSupplier(@PathVariable Long supplierId)
    {

        return supplierService.editSupplier(supplierId);
    }

    @PutMapping("/update/{supplierId}")
    public String updateSupplier(@RequestBody SupplierDTO supplierDTO,@PathVariable Long supplierId)
    {
        return supplierService.updateSupplier(supplierDTO, supplierId);
    }
}
