package com.backend.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.backend.dtos.TableDTO;
import com.backend.services.interfaces.ITableService;

@RestController
@RequestMapping("table")
@CrossOrigin(origins = "*")
public class TableController {
    @Autowired
    private ITableService tableService;

    @PostMapping("/add-tables")
    public TableDTO addTable(@RequestBody TableDTO tableDTO) {
        return tableService.addTable(tableDTO);
    }
}
