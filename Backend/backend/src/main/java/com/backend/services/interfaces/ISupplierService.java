package com.backend.services.interfaces;

import java.util.List;

import com.backend.dtos.SupplierDTO;

public interface ISupplierService {
    SupplierDTO addSupplier(SupplierDTO supplierDTO);
    public List<SupplierDTO> allSuppliers();
    public String deleteSupplier(Long supplierid);
    public SupplierDTO editSupplier(Long supplierId);
    public String updateSupplier(SupplierDTO supplierDTO,Long supplierId);
}
