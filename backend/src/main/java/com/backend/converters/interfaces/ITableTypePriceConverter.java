package com.backend.converters.interfaces;

import java.util.List;

import com.backend.dtos.TableTypePriceDTO;
import com.backend.pojos.TableTypePricePOJO;

public interface ITableTypePriceConverter {
    public TableTypePricePOJO dtoToPojo(TableTypePriceDTO tableTypePriceDTO);

    public List<TableTypePricePOJO> dtoToPojo(List<TableTypePriceDTO> tableTypePriceDTOs);

    public TableTypePriceDTO pojoToDto(TableTypePricePOJO tableTypePricePOJO);

    public List<TableTypePriceDTO> pojoToDto(List<TableTypePricePOJO> tableTypePricePOJOs);
}
