package com.backend.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.backend.converters.TableTypePriceConverter;
import com.backend.daos.ITableTypePriceDAO;
import com.backend.dtos.TableTypePriceDTO;
import com.backend.pojos.TableTypePricePOJO;

@Service
@Transactional
public class TableTypePriceService {
    
    @Autowired
    private ITableTypePriceDAO tableTypePriceDAO;
    @Autowired
    private TableTypePriceConverter tableTypePriceConverter;
    @Autowired
    private ModelMapper modelMapper;
    
    public TableTypePricePOJO addTable(TableTypePriceDTO tableTypePriceDTO){
        TableTypePricePOJO persistedTableTypePricePOJO=tableTypePriceConverter.dtoToPojo(tableTypePriceDTO);
        
        return tableTypePriceDAO.save(persistedTableTypePricePOJO);
    } 

    public TableTypePriceDTO showAllTableType(Long tableTypeId){
        TableTypePricePOJO persistedTableType =  tableTypePriceDAO.findById(tableTypeId).get();
        return modelMapper.map(persistedTableType, TableTypePriceDTO.class);
    }

    public List<TableTypePriceDTO> listTypesOfTables(){
        return tableTypePriceConverter.pojoToDto(tableTypePriceDAO.findAll());
    }
}
