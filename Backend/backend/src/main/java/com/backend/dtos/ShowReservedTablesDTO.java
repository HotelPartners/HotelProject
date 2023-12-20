package com.backend.dtos;

import java.time.LocalDate;
import java.time.LocalTime;

import javax.persistence.Column;

import org.springframework.stereotype.Component;

import com.backend.pojos.enums.TableType;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Component
@Getter
@Setter
@NoArgsConstructor
public class ShowReservedTablesDTO {
	private Long id;
    private Long tableNo;
    private Long userId;
    private TableType tableType;

    private LocalTime startTime;
    private LocalTime endTime;
    private LocalDate reservationDate;

    private Double price;
    private String status;
}
