package com.backend.pojos;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


import javax.persistence.OneToMany;
import javax.persistence.Table;



import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString
@Entity
@Table(name = "supplier")
public class SupplierPOJO {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "supplier_id")
    private Long supplierId;
    
    @Column(name = "supplier_name")
    private String supplierName;

    @Column(name = "supplier_address")
    private String supplierAddress;

    @Column(name = "supplier_contact")
    private String supplierContact;

    @Column(name="supplier_shoptype")
    private String shopType;

    // @ManyToOne
    // @JoinColumn(name = "shop_type")
    // private ShopPOJO shopType;

    @OneToMany(mappedBy = "ingredientBySupplier", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<IngredientPOJO> ingredients = new HashSet<>();

    public void addIngredient(IngredientPOJO ingredientPOJO){
        ingredientPOJO.setIngredientBySupplier(this);
        this.ingredients.add(ingredientPOJO);
    }

    public void removeIngredient(IngredientPOJO ingredientPOJO){
        ingredientPOJO.setIngredientBySupplier(null);
        this.ingredients.remove(ingredientPOJO);
    }

}
