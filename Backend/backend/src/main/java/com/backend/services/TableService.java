package com.backend.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.backend.converters.interfaces.ITableConverter;
import com.backend.daos.ITableDAO;
import com.backend.dtos.TableDTO;
import com.backend.pojos.TablePOJO;
import com.backend.services.interfaces.ILiveTableService;
import com.backend.services.interfaces.ITableService;

@Service
@Transactional
public class TableService implements ITableService {

    @Autowired
    private ITableDAO tableDAO;
    @Autowired
    private ITableConverter tableConverter;
    @Autowired
    private ILiveTableService liveTableService;

    @Override
    public TableDTO addTable(TableDTO tableDTO) {
        TablePOJO tablePOJO = tableConverter.dtoToPojo(tableDTO);
        liveTableService.addRowsAutomatically(tablePOJO);
        return tableConverter.pojoToDto(tableDAO.save(tablePOJO));
    }

}
