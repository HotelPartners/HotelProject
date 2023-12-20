package com.backend.pojos;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
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
@Table(name = "live_table")
public class LiveTablePOJO {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "row_id")
    private Long rowId;

    @Column(name = "reservation_date")
    private LocalDate reservationDate;

    @Column(name = "start_time")
    private LocalTime startTime;

    @Column(name = "end_time")
    private LocalTime endTime;

    @Column(name = "available_seats")
    private Long availableSeats;

    @ManyToOne
    @JoinColumn(name = "table_id")
    private TablePOJO tableReference;

    @ManyToMany( fetch = FetchType.LAZY)
    @JoinTable(name = "live_table_reservation", joinColumns = @JoinColumn(name = "live_table_id"), inverseJoinColumns = @JoinColumn(name = "table_reservation_id"))
    private Set<TableReservationPOJO> tableReservationPOJOs = new HashSet<>();

    public Boolean addTableReservation (TableReservationPOJO tableReservationPOJO){
        tableReservationPOJO.getLiveTablePOJOs().add(this);
        return this.tableReservationPOJOs.add(tableReservationPOJO);
    }

    public Boolean removeTableReservation (TableReservationPOJO tableReservationPOJO){
        tableReservationPOJO.getLiveTablePOJOs().remove(this);
        return this.tableReservationPOJOs.remove(tableReservationPOJO);
    }

    public void decreaseAvailableSeats(){
        availableSeats--;
    }

     public void increaseAvailableSeats(){
        availableSeats++;
    }

}
