package com.backend.converters;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.backend.converters.interfaces.ITableReservationConverter;
import com.backend.dtos.TableReservationDTO;
import com.backend.dtos.TableTypePriceDTO;
import com.backend.pojos.TableReservationPOJO;
import com.backend.pojos.TableTypePricePOJO;


@Component
public class TableReservationConverter implements ITableReservationConverter {

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public TableReservationPOJO dtoToPojo(TableReservationDTO tableReservationDTO) {
        return modelMapper.map(tableReservationDTO,TableReservationPOJO.class);
    }

    @Override
    public List<TableReservationPOJO> dtoToPojo(List<TableReservationDTO> tableReservationDTOs) {
       return tableReservationDTOs.stream().map(x->dtoToPojo(x)).collect(Collectors.toList());
    }

    @Override
    public TableReservationDTO pojoToDto(TableReservationPOJO tableReservationPOJO) {
       return modelMapper.map(tableReservationPOJO,TableReservationDTO.class);
    }

    @Override
    public List<TableReservationDTO> pojoToDto(List<TableReservationPOJO> tableReservationPOJOs) {
     return tableReservationPOJOs.stream().map(x->pojoToDto(x)).collect(Collectors.toList());   
    }

    
}
