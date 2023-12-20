package com.backend.converters;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.backend.dtos.ShowReservedTablesDTO;
import com.backend.pojos.ShowReservedTableHistoryPOJO;

@Component
public class ShowTablesReservationHistoryConverter {

    @Autowired
    private ModelMapper modelMapper;

    public ShowReservedTablesDTO pojoToDto(ShowReservedTableHistoryPOJO showReservedTableHistoryPOJO){
        return modelMapper.map(showReservedTableHistoryPOJO, ShowReservedTablesDTO.class);
    }

    public List<ShowReservedTablesDTO> pojoToDto(List<ShowReservedTableHistoryPOJO> showReservedTableHistoryPOJOs){
        return showReservedTableHistoryPOJOs.stream().map(x -> pojoToDto(x)).collect(Collectors.toList());
    }
}
