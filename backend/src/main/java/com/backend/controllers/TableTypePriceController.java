package com.backend.controllers;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.backend.dtos.TableTypePriceDTO;
import com.backend.pojos.TableTypePricePOJO;
import com.backend.services.TableTypePriceService;

@RestController
@RequestMapping("/table")
public class TableTypePriceController {

    @Autowired
    private TableTypePriceService tableTypePriceService;

    // @Autowired
    // private ModelMapper modelMapper;

    @PostMapping("/add-table-type")
    public TableTypePricePOJO addTable(@RequestBody TableTypePriceDTO tableTypePriceDTO)
    {
        return tableTypePriceService.addTable(tableTypePriceDTO);
    }

    @GetMapping("/table-types/{tableTypeId}")
    public TableTypePriceDTO showAllTableType(@PathVariable Long tableTypeId){
        return tableTypePriceService.showAllTableType(tableTypeId);
    }

    @GetMapping("/all-table-type")
    public List<TableTypePriceDTO> listTypesOfTables(){
        return tableTypePriceService.listTypesOfTables();
    }
}
