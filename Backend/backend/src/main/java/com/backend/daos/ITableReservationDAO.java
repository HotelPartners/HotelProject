package com.backend.daos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.backend.pojos.TableReservationPOJO;
import java.util.List;
import com.backend.pojos.UserPOJO;


public interface ITableReservationDAO extends JpaRepository<TableReservationPOJO,Long> {
    List<TableReservationPOJO> findByUserAndTableNo(UserPOJO user, Long tableNo);
}
