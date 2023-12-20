package com.backend.pojos;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
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
@Table(name = "table_reservation")
public class TableReservationPOJO {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long reservationId;

    @Column(name = "table_no")
    private Long tableNo;
    
    @ManyToOne
    @JoinColumn(name = "user_id")
    private UserPOJO user;

    @ManyToMany(mappedBy = "tableReservationPOJOs", fetch = FetchType.LAZY)
    private Set<LiveTablePOJO> liveTablePOJOs = new HashSet<>();

    public Boolean addTables (LiveTablePOJO liveTablePOJO){
        liveTablePOJO.getTableReservationPOJOs().add(this);
        return this.liveTablePOJOs.add(liveTablePOJO);
    }

    public Boolean removeTables (LiveTablePOJO liveTablePOJO){
        liveTablePOJO.getTableReservationPOJOs().remove(this);
        return this.liveTablePOJOs.remove(liveTablePOJO);
    }
}
