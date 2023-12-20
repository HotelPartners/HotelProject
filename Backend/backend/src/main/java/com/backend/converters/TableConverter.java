package com.backend.converters;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.backend.converters.interfaces.ITableConverter;
import com.backend.dtos.TableDTO;
import com.backend.pojos.TablePOJO;

@Component
public class TableConverter implements ITableConverter{

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public TablePOJO dtoToPojo(TableDTO tableDTO) {
        
        return modelMapper.map(tableDTO, TablePOJO.class);

    }

    @Override
    public List<TablePOJO> dtoToPojo(List<TableDTO> tableDTOs) {
        return tableDTOs.stream().map(x -> dtoToPojo(x)).collect(Collectors.toList());
    }

    @Override
    public TableDTO pojoToDto(TablePOJO tablePOJO) {
        //  TableTypePriceDTO tableTypePriceDTO=new TableTypePriceDTO();

        return modelMapper.map(tablePOJO, TableDTO.class);
        
    }

    @Override
    public List<TableDTO> pojoToDto(List<TablePOJO> tablePOJOs) {
        return tablePOJOs.stream().map(x -> pojoToDto(x)).collect(Collectors.toList());
    }
    
}
