package com.backend.dtos;

import org.springframework.stereotype.Component;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Component
@Getter
@Setter
@NoArgsConstructor
public class SupplierDTO {
    private Long supplierId;
    private String supplierName;
    private String supplierContact;
    private String supplierAddress;
    private String shopType;
}
