package com.backend.services;

import java.util.List;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.backend.daos.ICancelledTableDAO;
import com.backend.daos.ILiveTableDAO;
import com.backend.daos.IShowReservedTablesHistoryDAO;
import com.backend.daos.ITableDAO;
import com.backend.daos.ITableReservationDAO;
import com.backend.daos.IUserDAO;
import com.backend.dtos.CancelledTableDTO;
import com.backend.pojos.CancelledTablePOJO;
import com.backend.pojos.LiveTablePOJO;
import com.backend.pojos.TablePOJO;
import com.backend.pojos.TableReservationPOJO;
import com.backend.pojos.UserPOJO;

@Service
@Transactional
public class CancelledTableService {

    @Autowired
    private ITableReservationDAO tableReservationDAO;
    @Autowired
    private IUserDAO userDAO;
    @Autowired
    private IShowReservedTablesHistoryDAO showReservedTablesHistoryDAO;
    @Autowired
    private ICancelledTableDAO cancelledTableDAO;
    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private ITableDAO tableDAO;
    @Autowired
    private ILiveTableDAO liveTableDAO;

    public void showCancelledTables(Long userId) {

    }

    public CancelledTableDTO cancelTable(CancelledTableDTO cancelledTableDTO) {
        UserPOJO userPOJO = userDAO.findById(cancelledTableDTO.getUserId()).get();
        TablePOJO tablePOJO = tableDAO.findByTableType(cancelledTableDTO.getTableType());
        List<TableReservationPOJO> tableReservationPOJOs = tableReservationDAO.findByUserAndTableNo(userPOJO,
        cancelledTableDTO.getTableNo());
        for (TableReservationPOJO tableReservationPOJO : tableReservationPOJOs) {
            userPOJO.removeTableReservation(tableReservationPOJO);
            userDAO.save(userPOJO);
            System.out.println("in outer for loop");
            Set<LiveTablePOJO> liveTablePOJOs = tableReservationPOJO.getLiveTablePOJOs();
            CopyOnWriteArraySet<LiveTablePOJO> cwArraySet = new CopyOnWriteArraySet<>(liveTablePOJOs);
            for (LiveTablePOJO liveTablePOJO : cwArraySet) {
                System.out.println("in inner for loop");
                // tablePOJO.removeLiveTable(liveTablePOJO);
                liveTablePOJO.increaseAvailableSeats();
                liveTableDAO.save(liveTablePOJO);
                
                liveTablePOJO.removeTableReservation(tableReservationPOJO);
            }
            System.out.println("outside inner loop");
            System.out.println("userPOJO executed");
            tableReservationDAO.delete(tableReservationPOJO);
            System.out.println("table reservation removed successfully");

        }


        System.out.println("outside for loop");
        showReservedTablesHistoryDAO.delete(
                showReservedTablesHistoryDAO.findByUserIdAndStartTimeAndEndTimeAndTableNoAndTableTypeAndReservationDate(
                                cancelledTableDTO.getUserId(), cancelledTableDTO.getStartTime(),
                                cancelledTableDTO.getEndTime(), cancelledTableDTO.getTableNo(),
                                cancelledTableDTO.getTableType(), cancelledTableDTO.getReservationDate()));
        System.out.println("reservation history deleted successfully!!");

        CancelledTablePOJO cancelledTablePOJO = modelMapper.map(cancelledTableDTO, CancelledTablePOJO.class);

        cancelledTablePOJO.setPaidPrice(tablePOJO.getPrice());

        cancelledTablePOJO.setRefundAmount(tablePOJO.getPrice() * 0.9);

        cancelledTableDAO.save(cancelledTablePOJO);
        System.out.println("cancelled ticket saved successfully");
        cancelledTableDTO = modelMapper.map(cancelledTablePOJO, CancelledTableDTO.class);

        return cancelledTableDTO;

    }
}
