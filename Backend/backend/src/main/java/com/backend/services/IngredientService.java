package com.backend.services;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.backend.converters.interfaces.IIngredientConverter;
import com.backend.converters.interfaces.IIngredientsWithSupplierConverter;
import com.backend.daos.IIngredientDAO;
import com.backend.daos.ISupplierDAO;
import com.backend.dtos.IngredientDTO;
import com.backend.dtos.IngredientsWithSupplierDTO;
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
    @Autowired
    private IIngredientsWithSupplierConverter iIngredientsWithSupplierConverter;

    @Override
    public IngredientDTO addIngredient(IngredientDTO ingredientDTO, String supplierName) {

        SupplierPOJO supplierPOJO = supplierDAO.findBySupplierName(supplierName);
        IngredientPOJO ingredientPOJO = ingredientConverter.dtoToPojo(ingredientDTO);
        ingredientPOJO.setIngredientBySupplier(supplierPOJO);
        ingredientPOJO.getIngredientBySupplier().addIngredient(ingredientPOJO);

        return ingredientConverter.pojoToDto(ingredientDAO.save(ingredientPOJO));
    }

    @Override
    public List<IngredientsWithSupplierDTO> allIngrediens() {
        List<IngredientsWithSupplierDTO> ingredientsWithSupplierDTO = new ArrayList<>();
        List<IngredientPOJO> ingredientPOJOs = ingredientDAO.findAll();
        for (IngredientPOJO ingredientPOJO : ingredientPOJOs) {
            IngredientsWithSupplierDTO element = new IngredientsWithSupplierDTO();
            element.setIngredientId(ingredientPOJO.getIngredientId());
            element.setIngredientName(ingredientPOJO.getIngredientName());
            element.setIngredientCapacity(ingredientPOJO.getIngredientCapacity());
            element.setDateOfIngredientAdded(ingredientPOJO.getDateOfIngredientAdded());
            element.setSupplierName(ingredientPOJO.getIngredientBySupplier().getSupplierName());
            ingredientsWithSupplierDTO.add(element);
        }
        return ingredientsWithSupplierDTO;
    }

    @Override
    public String updateIngredient(IngredientDTO ingredientDTO, String supplierName, Long ingredientId) {
        IngredientPOJO ingredientPOJO = ingredientDAO.findById(ingredientId).get();
         SupplierPOJO supplierPOJO = supplierDAO.findBySupplierName(supplierName);
        ingredientPOJO.setIngredientName(ingredientDTO.getIngredientName());
        ingredientPOJO.setDateOfIngredientAdded(ingredientDTO.getDateOfIngredientAdded());
        ingredientPOJO.setIngredientCapacity(ingredientDTO.getIngredientCapacity());
        ingredientPOJO.setIngredientBySupplier(supplierPOJO);
        ingredientPOJO.setIngredientId(ingredientId);
        ingredientDAO.save(ingredientPOJO);
        return "success";
    }

    @Override
    public String deleteIngredient(Long ingredientId) {
        IngredientPOJO ingredientPOJO = ingredientDAO.findById(ingredientId).get();
        // System.out.println("Ingredient POJO = "+ingredientPOJO); Donot comment this
        // out unless you want stack overflow exception
        ingredientPOJO.getIngredientBySupplier().removeIngredient(ingredientPOJO);
        return "success";
    }

    @Override
    public IngredientsWithSupplierDTO editIngredient(Long ingredientId) {
        IngredientPOJO ingredientPOJO = ingredientDAO.findById(ingredientId).get();
        IngredientsWithSupplierDTO element = new IngredientsWithSupplierDTO();
        element.setIngredientId(ingredientPOJO.getIngredientId());
        element.setIngredientName(ingredientPOJO.getIngredientName());
        element.setIngredientCapacity(ingredientPOJO.getIngredientCapacity());
        element.setDateOfIngredientAdded(ingredientPOJO.getDateOfIngredientAdded());
        element.setSupplierName(ingredientPOJO.getIngredientBySupplier().getSupplierName());
        return element;
    }
}
