package com.backend.dtos;

import java.time.LocalDate;
import java.time.LocalTime;

import org.springframework.stereotype.Component;

import com.backend.deserialiser.CustomLocalDateDeserializer;
import com.backend.deserialiser.CustomLocalTimeDeserializer;
import com.backend.pojos.enums.TableType;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Component
@Getter
@Setter
@NoArgsConstructor
public class CancelledTableDTO {
    private Long userId;
    private Long tableNo;
    //@JsonDeserialize(using = CustomLocalDateDeserializer.class)
    private LocalDate reservationDate;
    // @JsonDeserialize(using = CustomLocalTimeDeserializer.class)
    private LocalTime startTime;
    // @JsonDeserialize(using = CustomLocalTimeDeserializer.class)
    private LocalTime endTime;
    private TableType tableType;
}
