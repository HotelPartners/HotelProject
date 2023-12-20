package com.backend.dtos;

import java.time.LocalDate;
import java.time.LocalTime;

import org.springframework.stereotype.Component;

import com.backend.deserialiser.CustomLocalDateDeserializer;
import com.backend.deserialiser.CustomLocalTimeDeserializer;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Component
@Getter
@Setter
@ToString
@NoArgsConstructor

public class TableReservationDTO {
    @JsonDeserialize(using = CustomLocalTimeDeserializer.class)
    private LocalTime startTime;
    private Long endTime;
    @JsonDeserialize(using = CustomLocalDateDeserializer.class)
    private LocalDate reservationDate;
}
