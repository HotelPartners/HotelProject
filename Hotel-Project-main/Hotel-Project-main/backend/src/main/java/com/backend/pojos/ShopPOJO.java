package com.backend.pojos;

import java.util.ArrayList;
import java.util.List;

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

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "shop_type")
public class ShopPOJO {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "shop_type_id")
    private Long shopTypeId;

    @Column(name = "shop_type")
    private String shopType;

    @OneToMany(mappedBy = "shopType", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<SupplierPOJO> suppliers = new ArrayList<>();

    public Boolean addSupplier(SupplierPOJO supplierPOJO){
        supplierPOJO.setShopType(this);
        return this.suppliers.add(supplierPOJO);
    }

    public Boolean removeSupplier(SupplierPOJO supplierPOJO){
        supplierPOJO.setShopType(null);
        return this.suppliers.remove(supplierPOJO);
    }

}
