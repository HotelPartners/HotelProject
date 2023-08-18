package com.backend.dtos;

import java.time.LocalDateTime;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.*;


import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@Component
public class TableReservationDTO {
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    private LocalDateTime startTime;
    
}
