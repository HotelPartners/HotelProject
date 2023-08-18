package com.backend.pojos;

import java.util.ArrayList;
import java.util.List;

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
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

//Child Table of DiningVenuePOJO

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "dining_table")
public class DiningTablePOJO{
    @Id
    @Column(name = "table_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long tableId;
 
    // @ManyToOne
    // @JoinColumn(name = "table_type_id")
    // private TableTypePricePOJO tableType;

    // @OneToMany(mappedBy = "diningTable", cascade = CascadeType.ALL, orphanRemoval = true)
    // private List<TableReservationPOJO> bookedTables =new ArrayList<>();

}
