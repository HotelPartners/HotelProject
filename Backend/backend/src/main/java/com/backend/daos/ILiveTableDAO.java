package com.backend.daos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.backend.pojos.LiveTablePOJO;
import java.util.List;
import java.time.LocalDate;
import java.time.LocalTime;
import com.backend.pojos.TablePOJO;


public interface ILiveTableDAO extends JpaRepository<LiveTablePOJO, Long>{
    LiveTablePOJO findByStartTimeAndReservationDateAndTableReference(LocalTime startTime, LocalDate reservationDate, TablePOJO tableReference);
}
