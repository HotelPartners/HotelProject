package com.backend.pojos;

import java.time.LocalDate;
import java.time.LocalTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.backend.pojos.enums.TableType;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "table_reservation_history")
public class ShowReservedTableHistoryPOJO {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "user_id")
    private Long userId;
    
    @Column(name = "table_no")
    private Long tableNo;

    @Column(name = "table_type")
    private TableType tableType;

    @Column(name = "start_time")
    private LocalTime startTime;

    @Column(name = "end_time")
    private LocalTime endTime;

    @Column(name = "reservation_date")
    private LocalDate reservationDate;

    @Column(name = "price")
    private Double price;

    @Column(name= "status")
    private String status;

    public ShowReservedTableHistoryPOJO(Long userId, Long tableNo, TableType tableType, LocalTime startTime,
            LocalTime endTime, LocalDate reservationDate, Double price) {
        this.userId = userId;
        this.tableNo = tableNo;
        this.tableType = tableType;
        this.startTime = startTime;
        this.endTime = endTime;
        this.reservationDate = reservationDate;
        this.price = price;
    }

   

    
}
