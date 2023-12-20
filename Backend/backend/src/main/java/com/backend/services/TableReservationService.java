package com.backend.services;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.time.Duration;
import java.time.LocalTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.backend.converters.ShowTablesReservationHistoryConverter;
import com.backend.daos.ILiveTableDAO;
import com.backend.daos.IShowReservedTablesHistoryDAO;
import com.backend.daos.ITableDAO;
import com.backend.daos.ITableReservationDAO;
import com.backend.daos.IUserDAO;
import com.backend.dtos.ConfirmTableReservationDetails;
import com.backend.dtos.ShowReservedTablesDTO;
import com.backend.dtos.TableReservationDTO;
import com.backend.pojos.LiveTablePOJO;
import com.backend.pojos.ShowReservedTableHistoryPOJO;
import com.backend.pojos.TablePOJO;
import com.backend.pojos.TableReservationPOJO;
import com.backend.pojos.UserPOJO;
import com.backend.pojos.enums.TableType;
import com.backend.services.interfaces.ITableReservationService;

@Service
@Transactional
public class TableReservationService implements ITableReservationService {

    @Autowired
    private IUserDAO userDAO;
    @Autowired
    private ITableDAO tableDAO;
    @Autowired
    private ILiveTableDAO liveTableDAO;
    @Autowired
    private ITableReservationDAO tableReservationDAO;
    @Autowired
    private IShowReservedTablesHistoryDAO showReservedTablesHistoryDAO;
    @Autowired
    private ShowTablesReservationHistoryConverter showTablesReservationHistoryConverter;

    @Override
    public ConfirmTableReservationDetails addReservation(TableReservationDTO tableReservationDTO, String userEmail,
            TableType tableType) {
             
        UserPOJO userPOJO = userDAO.findByUserEmail(userEmail).get();
        TablePOJO tablePOJO = tableDAO.findByTableType(tableType);
        TableReservationPOJO tableReservationPOJO = new TableReservationPOJO();

        List<LiveTablePOJO> liveTablePOJOs = new ArrayList<>();

        LocalTime endTime = tableReservationDTO.getStartTime().plusHours(tableReservationDTO.getEndTime());
        System.out.println(endTime+"****************-----------------------**********************************************/////////////////////////////////");
        for (LocalTime start = tableReservationDTO.getStartTime(); start != endTime; start = start.plusHours(1)) {

            LiveTablePOJO liveTablePOJO = liveTableDAO.findByStartTimeAndReservationDateAndTableReference(
                    start, tableReservationDTO.getReservationDate(), tablePOJO);

            if (liveTablePOJO.getAvailableSeats() <= 0L) {
                return new ConfirmTableReservationDetails();
            }

            liveTablePOJOs.add(liveTablePOJO);
        }

        LiveTablePOJO liveTablePOJO = Collections.min(liveTablePOJOs,
                (x, y) -> Long.compare(x.getAvailableSeats(), y.getAvailableSeats()));
        Long tableNo = liveTablePOJO.getAvailableSeats();
        for (LiveTablePOJO liveTablePOJO2 : liveTablePOJOs) {
            liveTablePOJO2.decreaseAvailableSeats();
            tableReservationPOJO.addTables(liveTablePOJO2);
        }
        tableReservationPOJO.setTableNo(tableNo);
        tableReservationPOJO.setUser(userPOJO);
        tableReservationDAO.save(tableReservationPOJO);

        long duration = Duration.between(tableReservationDTO.getStartTime(), endTime).toSeconds();
        double hours = duration / 3600;
        Double price = hours * tablePOJO.getPrice();

        ShowReservedTableHistoryPOJO showReservedTableHistoryPOJO = new ShowReservedTableHistoryPOJO(userPOJO.getUserId(), tableNo, tableType,tableReservationDTO.getStartTime(), endTime, tableReservationDTO.getReservationDate(), price);

        addToReservationHistory(showReservedTableHistoryPOJO);

        return new ConfirmTableReservationDetails(tablePOJO.getTableType(),tableNo,tableReservationDTO.getStartTime(),endTime,tableReservationDTO.getReservationDate());

    }

    @Override
    public List<ShowReservedTablesDTO> showReservations(String userEmail) {
    	UserPOJO userpojo=userDAO.findByUserEmail(userEmail).get();
        List<ShowReservedTableHistoryPOJO> showReservedTableHistoryPOJO=showReservedTablesHistoryDAO.findByUserId(userpojo.getUserId());
        return showTablesReservationHistoryConverter.pojoToDto(showReservedTableHistoryPOJO);
    }

    public String addToReservationHistory(ShowReservedTableHistoryPOJO showReservedTableHistoryPOJO){
        showReservedTableHistoryPOJO.setStatus("CONFIRMED");
        ShowReservedTableHistoryPOJO showReservedTableHistoryPOJO2 = showReservedTablesHistoryDAO.save(showReservedTableHistoryPOJO);

        if(showReservedTableHistoryPOJO2 != null){
            return "Success";
        } else{
            return "Failed";
        }
    }

	@Override
	public List<ShowReservedTablesDTO> allTableDetails() {
		 List<ShowReservedTableHistoryPOJO> showReservedTableHistoryPOJO=showReservedTablesHistoryDAO.findAll();
	        return showTablesReservationHistoryConverter.pojoToDto(showReservedTableHistoryPOJO);
	}

	@Override
	public String updateTableStatus(Long orderId) {
		ShowReservedTableHistoryPOJO reservationpojo = showReservedTablesHistoryDAO.findById(orderId).get();
		reservationpojo.setStatus("COMPLETED");
		return reservationpojo.getStatus();
	}

}
