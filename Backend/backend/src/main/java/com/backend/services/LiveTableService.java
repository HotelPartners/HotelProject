package com.backend.services;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.backend.converters.interfaces.ILiveTableConverter;
import com.backend.daos.ILiveTableDAO;
import com.backend.daos.ITableDAO;
import com.backend.dtos.LiveTableDTO;
import com.backend.pojos.LiveTablePOJO;
import com.backend.pojos.TablePOJO;
import com.backend.services.interfaces.ILiveTableService;

@Service
@Transactional
public class LiveTableService implements ILiveTableService {

    @Autowired
    private ILiveTableDAO liveTableDAO;
    @Autowired
    private ILiveTableConverter liveTableConverter;

    private TablePOJO tablePOJO = new TablePOJO();

    @Autowired
    private ITableDAO tableDAO;

    @Override
    public LiveTableDTO addLiveTables(LiveTableDTO liveTableDTO) {
        LiveTablePOJO liveTablePOJO = liveTableConverter.dtoToPojo(liveTableDTO);
        tablePOJO.addLiveTable(liveTablePOJO);
        return liveTableConverter.pojoToDto(liveTableDAO.save(liveTablePOJO));

    }

    @Override
    public void addRowsAutomatically(TablePOJO tablePOJO) {
        LocalTime[] startTimes = { LocalTime.of(8, 00), LocalTime.of(9, 00), LocalTime.of(10, 00), LocalTime.of(11, 00),
                LocalTime.of(12, 00), LocalTime.of(13, 00), LocalTime.of(14, 00), LocalTime.of(15, 00),
                LocalTime.of(16, 00), LocalTime.of(17, 00), LocalTime.of(18, 00), LocalTime.of(19, 00),
                LocalTime.of(20, 00), LocalTime.of(21, 00), LocalTime.of(22, 00), LocalTime.of(23, 00) };

        LocalDate[] dates = { LocalDate.now(), LocalDate.now().plusDays(1), LocalDate.now().plusDays(2),
                LocalDate.now().plusDays(3), LocalDate.now().plusDays(4), LocalDate.now().plusDays(5),
                LocalDate.now().plusDays(6)};

        // List<TablePOJO> tablePOJOs = tableDAO.findAll();

        for (LocalDate date : dates) {
            for (LocalTime startTime : startTimes) {
                LiveTablePOJO liveTablePOJO = new LiveTablePOJO();
                liveTablePOJO.setStartTime(startTime);
                liveTablePOJO.setEndTime(startTime.plusHours(1));
                liveTablePOJO.setReservationDate(date);

                liveTablePOJO.setAvailableSeats(tablePOJO.getTotalTables());
                liveTablePOJO.setTableReference(tablePOJO);
                liveTableDAO.save(liveTablePOJO);

            }
            // liveTableDAO.save(liveTablePOJO);
        }
    }

}
