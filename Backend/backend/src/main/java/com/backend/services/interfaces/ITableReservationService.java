package com.backend.services.interfaces;

import java.util.List;

import com.backend.dtos.ConfirmTableReservationDetails;
import com.backend.dtos.ShowReservedTablesDTO;
import com.backend.dtos.TableReservationDTO;
import com.backend.pojos.enums.TableType;

public interface ITableReservationService {
    public ConfirmTableReservationDetails addReservation(TableReservationDTO tableReservationDTO, String userEmail,
            TableType tableType);
            public List<ShowReservedTablesDTO> showReservations(String userEmail);
            public List<ShowReservedTablesDTO> allTableDetails();
            public String updateTableStatus(Long orderId);

}