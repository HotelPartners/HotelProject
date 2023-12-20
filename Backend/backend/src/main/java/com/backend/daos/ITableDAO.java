package com.backend.daos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.backend.pojos.TablePOJO;
import java.util.List;
import com.backend.pojos.enums.TableType;


public interface ITableDAO extends JpaRepository<TablePOJO, Long>{
    TablePOJO findByTableType(TableType tableType);
}
