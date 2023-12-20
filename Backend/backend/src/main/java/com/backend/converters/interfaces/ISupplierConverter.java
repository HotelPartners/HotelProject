package com.backend.converters.interfaces;

import java.util.List;

import com.backend.dtos.SupplierDTO;
import com.backend.pojos.SupplierPOJO;

public interface ISupplierConverter {
    public SupplierPOJO dtoToPojo(SupplierDTO supplierDTO);

    public List<SupplierPOJO> dtoToPojo(List<SupplierDTO> supplierDTOs);

    public SupplierDTO pojoToDto(SupplierPOJO supplierPOJO);

    public List<SupplierDTO> pojoToDto(List<SupplierPOJO> supplierPOJOs);
}
