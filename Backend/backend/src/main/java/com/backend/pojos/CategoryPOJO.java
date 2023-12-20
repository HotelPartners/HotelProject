package com.backend.pojos;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.backend.pojos.enums.CategoryType;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "category")
public class CategoryPOJO {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "category_id")
    private Long categoryId;

    @Column(name = "category_name")
    @Enumerated(EnumType.STRING)
    private CategoryType categoryName;

    @OneToMany(mappedBy = "category", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<MenuPOJO> items = new HashSet<>();

    public Boolean addItem(MenuPOJO menuPOJO){
        menuPOJO.setCategory(this);
        return this.items.add(menuPOJO);
    }

    public Boolean removeItem(MenuPOJO menuPOJO){
        menuPOJO.setCategory(null);
        return this.items.remove(menuPOJO);
    }


    
}