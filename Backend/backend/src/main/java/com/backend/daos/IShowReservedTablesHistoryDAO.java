package com.backend.daos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.backend.pojos.ShowReservedTableHistoryPOJO;
import java.util.List;
import java.time.LocalDate;
import java.time.LocalTime;
import com.backend.pojos.enums.TableType;



public interface IShowReservedTablesHistoryDAO extends JpaRepository<ShowReservedTableHistoryPOJO, Long>{
    List<ShowReservedTableHistoryPOJO> findByUserId(Long userId);
    ShowReservedTableHistoryPOJO findByUserIdAndStartTimeAndEndTimeAndTableNoAndTableTypeAndReservationDate(Long userId, LocalTime startTime, LocalTime endTime, Long tableNo, TableType tableType, LocalDate reservationDate);
}
