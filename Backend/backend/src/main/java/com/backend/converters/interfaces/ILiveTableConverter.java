package com.backend.converters.interfaces;

import java.util.List;

import com.backend.dtos.LiveTableDTO;
import com.backend.pojos.LiveTablePOJO;

public interface ILiveTableConverter {
    public LiveTablePOJO dtoToPojo(LiveTableDTO liveTableDTO);

    public List<LiveTablePOJO> dtoToPojo(List<LiveTableDTO> livTableDTOs);

    public LiveTableDTO pojoToDto(LiveTablePOJO liveTablePOJO);

    public List<LiveTableDTO> pojoToDto(List<LiveTablePOJO> liveTablePOJOs);
}
