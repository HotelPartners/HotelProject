package com.backend.pojos;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.backend.pojos.enums.VegorNonType;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "menu")
public class MenuPOJO {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "item_id")
    private Long itemId;

    @Column(name = "user_id")
    private Long userid;

    @Column(name = "item_name")
    private String itemName;

    @Column(name = "price")
    private double price;

    @Column(name = "category")
    @Enumerated(EnumType.STRING)
    private VegorNonType mealChoice;

    @Column(name = "item_image")
    private byte[] itemImage;

    @ManyToMany( fetch = FetchType.LAZY)
    @JoinTable(name = "item_ingredient", joinColumns = @JoinColumn(name = "item_id"), inverseJoinColumns = @JoinColumn(name = "ingredient_id"))
    private Set<IngredientPOJO> ingredients = new HashSet<>();
    
    public Boolean addIngredient(IngredientPOJO ingredientPOJO){
        ingredientPOJO.getItems().add(this);
        return this.ingredients.add(ingredientPOJO);
    }

    public Boolean removeIngredient(IngredientPOJO ingredientPOJO){
        ingredientPOJO.getItems().remove(this);
        return this.ingredients.remove(ingredientPOJO);
    }

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(name = "item_order", joinColumns = @JoinColumn(name = "item_id"), inverseJoinColumns = @JoinColumn(name = "order_id"))
    private Set<OrderPOJO> orders = new HashSet<>();

    public Boolean addOrder(OrderPOJO orderPOJO){
        orderPOJO.getItems().add(this);
        return this.orders.add(orderPOJO);
    }

    public Boolean removeOrder(OrderPOJO orderPOJO){
        orderPOJO.getItems().remove(this);
        return this.orders.remove(orderPOJO);
    }

    @ManyToOne
    @JoinColumn(name = "category_id")
    private CategoryPOJO category;
}