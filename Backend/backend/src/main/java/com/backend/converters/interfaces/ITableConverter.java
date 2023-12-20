package com.backend.converters.interfaces;

import java.util.List;

import com.backend.dtos.TableDTO;
import com.backend.pojos.TablePOJO;

public interface ITableConverter {
    public TablePOJO dtoToPojo(TableDTO tableDTO);

    public List<TablePOJO> dtoToPojo(List<TableDTO> tableDTOs);

    public TableDTO pojoToDto(TablePOJO tablePOJO);

    public List<TableDTO> pojoToDto(List<TablePOJO> tablePOJOs);
}
