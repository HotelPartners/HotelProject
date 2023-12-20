package com.backend.converters;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.backend.converters.interfaces.ILiveTableConverter;
import com.backend.dtos.LiveTableDTO;
import com.backend.pojos.LiveTablePOJO;

@Component
public class LiveTableConverter implements ILiveTableConverter{

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public LiveTablePOJO dtoToPojo(LiveTableDTO liveTableDTO) {
        return modelMapper.map(liveTableDTO, LiveTablePOJO.class);
    }

    @Override
    public List<LiveTablePOJO> dtoToPojo(List<LiveTableDTO> liveTableDTOs) {
        return liveTableDTOs.stream().map(x -> dtoToPojo(x)).collect(Collectors.toList());
    }

    @Override
    public LiveTableDTO pojoToDto(LiveTablePOJO liveTablePOJO) {
        return modelMapper.map(liveTablePOJO, LiveTableDTO.class);
    }

    @Override
    public List<LiveTableDTO> pojoToDto(List<LiveTablePOJO> liveTablePOJOs) {
        return liveTablePOJOs.stream().map(x -> pojoToDto(x)).collect(Collectors.toList());
    }
    
}
