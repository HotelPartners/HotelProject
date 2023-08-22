package com.backend.services.interfaces;

import com.backend.dtos.SupplierDTO;

public interface ISupplierService {
    SupplierDTO addSupplier(SupplierDTO supplierDTO, Long shopId);
}
