package com.backend.converters.interfaces;

import java.util.List;

import com.backend.dtos.TableReservationDTO;
import com.backend.pojos.TableReservationPOJO;


public interface ITableReservationConverter {
        public TableReservationPOJO dtoToPojo(TableReservationDTO tableReservationDTO);

    public List<TableReservationPOJO> dtoToPojo(List<TableReservationDTO> tableReservationDTOs);

    public TableReservationDTO pojoToDto(TableReservationPOJO tableReservationPOJO);

    public List<TableReservationDTO> pojoToDto(List<TableReservationPOJO> tableReservationPOJOs);

}
