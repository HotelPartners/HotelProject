package com.backend.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.backend.dtos.TableReservationDTO;
import com.backend.pojos.TableReservationPOJO;
import com.backend.services.TableReservationService;

@RestController
@RequestMapping("/table-reservation")
public class TableReservationController {
    @Autowired
    private TableReservationService tableReservationService;

    @PostMapping("/add-reservation/{userId}/{tableTypeId}")
    public TableReservationDTO AddReservation(TableReservationDTO tableReservationDTO, @PathVariable Long userId, @PathVariable Long tableTypeId)
    {
        return tableReservationService.addReservation(tableReservationDTO, userId, tableTypeId);
    }
}
