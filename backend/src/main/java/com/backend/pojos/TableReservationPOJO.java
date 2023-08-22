package com.backend.pojos;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
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

    @ManyToOne
    @JoinColumn(name = "live_table_id")
    private LiveTablePOJO liveTablePOJO;
}
