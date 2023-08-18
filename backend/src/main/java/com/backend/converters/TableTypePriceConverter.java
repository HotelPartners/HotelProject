package com.backend.converters;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.backend.converters.interfaces.ITableTypePriceConverter;
import com.backend.dtos.TableTypePriceDTO;
import com.backend.pojos.TableTypePricePOJO;

@Component
public class TableTypePriceConverter implements ITableTypePriceConverter{

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public TableTypePricePOJO dtoToPojo(TableTypePriceDTO tableTypePriceDTO) {
        
        return modelMapper.map(tableTypePriceDTO, TableTypePricePOJO.class);

    }

    @Override
    public List<TableTypePricePOJO> dtoToPojo(List<TableTypePriceDTO> tableTypePriceDTOs) {
        return tableTypePriceDTOs.stream().map(x -> dtoToPojo(x)).collect(Collectors.toList());
    }

    @Override
    public TableTypePriceDTO pojoToDto(TableTypePricePOJO tableTypePricePOJO) {
        //  TableTypePriceDTO tableTypePriceDTO=new TableTypePriceDTO();

        return modelMapper.map(tableTypePricePOJO, TableTypePriceDTO.class);
        
    }

    @Override
    public List<TableTypePriceDTO> pojoToDto(List<TableTypePricePOJO> tableTypePricePOJOs) {
        return tableTypePricePOJOs.stream().map(x -> pojoToDto(x)).collect(Collectors.toList());
    }
    
}
