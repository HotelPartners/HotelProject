package com.backend.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.backend.converters.TableReservationConverter;
import com.backend.daos.ITableReservationDAO;
import com.backend.daos.ITableTypePriceDAO;
import com.backend.daos.IUserDAO;
import com.backend.dtos.TableReservationDTO;
import com.backend.pojos.TableReservationPOJO;
import com.backend.pojos.TableTypePricePOJO;
import com.backend.pojos.UserPOJO;

@Service
@Transactional
public class TableReservationService {
    @Autowired
    private ITableReservationDAO tableReservationDAO;

    @Autowired
    private TableReservationConverter tableReservationConverter;

    @Autowired
    private IUserDAO userDAO;

    @Autowired
    private ITableTypePriceDAO tableTypePriceDAO;

    public TableReservationDTO addReservation(TableReservationDTO tableReservationDTO, Long userId, Long tableTypeId) {

        TableTypePricePOJO tableTypePricePOJO = tableTypePriceDAO.findById(tableTypeId).get();
        if (tableTypePricePOJO.getAvailableTables() <= 0) {
            System.out.println(tableTypePricePOJO.getAvailableTables());
            return null;
        } else {
            UserPOJO userPOJO = userDAO.findById(userId).get();

            TableReservationPOJO tableReservationPOJO = tableReservationConverter.dtoToPojo(tableReservationDTO);

            tableReservationPOJO.setUser(userPOJO);
            tableReservationPOJO.setReservedTableType(tableTypePricePOJO);

            userPOJO.getReservedTables().add(tableReservationPOJO);
            tableTypePricePOJO.getBookedTables().add(tableReservationPOJO);

            tableReservationPOJO = tableReservationDAO.save(tableReservationPOJO);
            tableTypePricePOJO.setAvailableTables(tableTypePricePOJO.getAvailableTables() - 1);
            return tableReservationConverter.pojoToDto(tableReservationPOJO);
        }

    }
}
