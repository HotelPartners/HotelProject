package com.backend.services.interfaces;

import com.backend.dtos.LiveTableDTO;
import com.backend.pojos.TablePOJO;

public interface ILiveTableService {
    LiveTableDTO addLiveTables (LiveTableDTO liveTableDTO);
    void addRowsAutomatically(TablePOJO tablePOJO);
}
