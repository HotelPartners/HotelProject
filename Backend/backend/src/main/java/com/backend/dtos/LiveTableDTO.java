package com.backend.dtos;

import java.time.LocalDate;
import java.time.LocalTime;

import org.springframework.stereotype.Component;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Component
@Getter
@Setter
@NoArgsConstructor
@ToString
public class LiveTableDTO {
    private LocalDate reservationDate;
    private LocalTime startTime;
    private LocalTime endTime;
    private Long availableSeats;

}
