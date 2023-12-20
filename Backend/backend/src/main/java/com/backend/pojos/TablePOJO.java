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
@Table(name = "tables")
public class TablePOJO {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "table_id")
    private Long tableId;

    @Enumerated(EnumType.STRING)
    @Column(name = "table_type")
    private TableType tableType;
    
    @Column(name = "price")
    private Double price;
    
    @Column(name = "table_image")
    private byte[] tableImage;
    
    @Column(name = "total_tables")
    private Long totalTables;

    @OneToMany(mappedBy = "tableReference", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<LiveTablePOJO> liveTablePOJOs = new ArrayList<>();

    public Boolean addLiveTable(LiveTablePOJO liveTablePOJO){
        liveTablePOJO.setTableReference(this);
        return this.liveTablePOJOs.add(liveTablePOJO);
    }

    public Boolean removeLiveTable(LiveTablePOJO liveTablePOJO){
        liveTablePOJO.setTableReference(null);
        return this.liveTablePOJOs.remove(liveTablePOJO);
    }

}
