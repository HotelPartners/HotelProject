package com.backend.pojos;

import java.util.ArrayList;
import java.util.List;

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


import com.backend.pojos.enums.TableType;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "table_type_price")
public class TableTypePricePOJO {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "table_type_id")
    private Long tableTypeId;

    @Enumerated(EnumType.STRING)
    @Column(name = "table_type")
    private TableType tableType;
    
    @Column(name = "price")
    private Double price;
    
    @Column(name = "table_image")
    private byte[] tableImage;
    
    @Column(name = "total_tables")
    private Long totalTables;

    @Column(name = "available_tables")
    private Long availableTables;

    @OneToMany(mappedBy = "reservedTableType", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<TableReservationPOJO> bookedTables =new ArrayList<>();

    // @OneToMany(mappedBy = "tableType", cascade = CascadeType.ALL, orphanRemoval = true)
    // private List<DiningTablePOJO> tables = new ArrayList<>();

    public void addTableReservation(TableReservationPOJO tableReservationPOJO) {
        bookedTables.add(tableReservationPOJO);// parent --> child link
        tableReservationPOJO.setReservedTableType(this);// child --> parent
    }

    public void removeTableReservation(TableReservationPOJO tableReservationPOJO) {
        bookedTables.remove(tableReservationPOJO);// parent --> child link
        tableReservationPOJO.setReservedTableType(null);// child ---X---> parent
    }


}
