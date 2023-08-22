package com.backend.pojos;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "ingredients")
public class IngredientPOJO {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ingredient_id")
    private Long ingredientId;

    @Column(name = "ingredient")
    private String ingredient;

    @Column(name = "inventory_capacity")
    private Long inventoryCapacity;

    @ManyToMany(mappedBy = "ingredients", fetch = FetchType.LAZY)
    private Set<MenuPOJO> items = new HashSet<>();

    public Boolean addIngredient(MenuPOJO menuPOJO){
        menuPOJO.getIngredients().add(this);
        return this.items.add(menuPOJO);
    }

    public Boolean removeIngredient(MenuPOJO menuPOJO){
        menuPOJO.getIngredients().remove(this);
        return this.items.remove(menuPOJO);
    }

    @ManyToOne
    @JoinColumn(name = "supplier_id")
    private SupplierPOJO ingredientBySupplier;  

}
