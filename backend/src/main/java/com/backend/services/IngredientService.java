package com.backend.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.backend.converters.interfaces.IIngredientConverter;
import com.backend.daos.IIngredientDAO;
import com.backend.daos.ISupplierDAO;
import com.backend.dtos.IngredientDTO;
import com.backend.pojos.IngredientPOJO;
import com.backend.pojos.SupplierPOJO;
import com.backend.services.interfaces.IIngredientService;

@Service
@Transactional
public class IngredientService implements IIngredientService {

    @Autowired
    private IIngredientDAO ingredientDAO;
    @Autowired
    private ISupplierDAO supplierDAO;
    @Autowired
    private IIngredientConverter ingredientConverter;

    @Override
    public IngredientDTO addIngredient(IngredientDTO ingredientDTO, Long supplierId) {
        SupplierPOJO supplierPOJO = supplierDAO.findById(supplierId).get();
        IngredientPOJO ingredientPOJO = ingredientConverter.dtoToPojo(ingredientDTO);
        ingredientPOJO.setIngredientBySupplier(supplierPOJO);
        return ingredientConverter.pojoToDto(ingredientDAO.save(ingredientPOJO));
    }
}
