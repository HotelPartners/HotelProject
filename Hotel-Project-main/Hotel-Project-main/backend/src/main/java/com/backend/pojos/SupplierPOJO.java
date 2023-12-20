package com.backend.pojos;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.backend.pojos.enums.ShopType;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "supplier")
public class SupplierPOJO {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "supplier_id")
    private Long supplierId;
    
    @Column(name = "supplier_name")
    private String supplierName;

    @ManyToOne
    @JoinColumn(name = "shop_type")
    private ShopPOJO shopType;

    @OneToMany(mappedBy = "ingredientBySupplier", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<IngredientPOJO> ingredients = new ArrayList<>();

    public Boolean addIngredient(IngredientPOJO ingredientPOJO){
        ingredientPOJO.setIngredientBySupplier(this);
        return this.ingredients.add(ingredientPOJO);
    }

    public Boolean removeIngredient(IngredientPOJO ingredientPOJO){
        ingredientPOJO.setIngredientBySupplier(null);
        return this.ingredients.remove(ingredientPOJO);
    }
    
    @OneToMany(mappedBy = "supplier", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<SupplierAddressPOJO> supplierAddresses = new ArrayList<>();

    public Boolean addSupplierAddress(SupplierAddressPOJO supplierAddressPOJO){
        supplierAddressPOJO.setSupplier(this);
        return this.supplierAddresses.add(supplierAddressPOJO);
    }

    public Boolean removeSupplierAddress(SupplierAddressPOJO supplierAddressPOJO){
        supplierAddressPOJO.setSupplier(null);
        return this.supplierAddresses.remove(supplierAddressPOJO);
    }

}
