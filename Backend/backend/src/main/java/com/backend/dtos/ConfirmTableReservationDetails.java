package com.backend.dtos;

import java.time.LocalDate;
import java.time.LocalTime;

import org.springframework.stereotype.Component;

import com.backend.pojos.enums.TableType;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Component
public class ConfirmTableReservationDetails {

    private TableType tableType;
    private Long tableNo;
    private LocalTime startTime;
    private LocalTime endTime;
    private LocalDate reservationDate;
    public ConfirmTableReservationDetails(TableType tableType, Long tableNo, LocalTime startTime, LocalTime endTime,
            LocalDate reservationDate) {
        this.tableType = tableType;
        this.tableNo = tableNo;
        this.startTime = startTime;
        this.endTime = endTime;
        this.reservationDate = reservationDate;    
    }

    
}
