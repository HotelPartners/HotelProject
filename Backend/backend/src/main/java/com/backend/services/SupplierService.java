package com.backend.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.backend.converters.interfaces.ISupplierConverter;
import com.backend.daos.ISupplierDAO;
import com.backend.dtos.SupplierDTO;
import com.backend.dtos.UserDTO;
import com.backend.pojos.SupplierPOJO;
import com.backend.services.interfaces.ISupplierService;

@Service
@Transactional
public class SupplierService implements ISupplierService {

    @Autowired
    private ISupplierDAO supplierDAO;
    @Autowired
    private ISupplierConverter supplierConverter;

   @Override
    public SupplierDTO addSupplier(SupplierDTO supplierDTO) {
        SupplierPOJO supplierPOJO = supplierConverter.dtoToPojo(supplierDTO);
        return supplierConverter.pojoToDto(supplierDAO.save(supplierPOJO));
    }

    @Override
    public List<SupplierDTO> allSuppliers() {
        return supplierConverter.pojoToDto(supplierDAO.findAll());
    }

    @Override
    public String deleteSupplier(Long supplierid) {
        try {
            supplierDAO.deleteById(supplierid);
            return "success";
        } catch (Exception ex) {
            return "error";
        }
    }

    @Override
    public SupplierDTO editSupplier(Long supplierId) {
       SupplierPOJO supplierPOJO=supplierDAO.findById(supplierId).get();
       return supplierConverter.pojoToDto(supplierPOJO);
    }

    

    @Override
    public String updateSupplier(SupplierDTO supplierDTO, Long supplierId) {
        SupplierPOJO supplierPOJO=supplierDAO.findById(supplierId).get();
        supplierPOJO.setSupplierName(supplierDTO.getSupplierName());
        supplierPOJO.setShopType(supplierDTO.getShopType());
        supplierPOJO.setSupplierAddress(supplierDTO.getSupplierAddress());
        supplierPOJO.setSupplierContact(supplierDTO.getSupplierContact());
        supplierDAO.save(supplierPOJO);

        return "success";
    }
    


   
    

}
