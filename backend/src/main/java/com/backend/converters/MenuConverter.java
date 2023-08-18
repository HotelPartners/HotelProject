package com.backend.converters;

import java.util.List;
import java.util.stream.Collectors;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.backend.converters.interfaces.IMenuConverter;
import com.backend.dtos.MenuDTO;
import com.backend.pojos.MenuPOJO;
import org.modelmapper.*;

@Component
public class MenuConverter implements IMenuConverter {
   
    @Autowired
    private ModelMapper modelMapper;

    public MenuPOJO dtoToPojo(MenuDTO menuDto)
    {
        return modelMapper.map(menuDto, MenuPOJO.class);
    }

    public List<MenuPOJO> dtoToPojo(List<MenuDTO> menuDto){
        return menuDto.stream().map(x -> dtoToPojo(x)).collect(Collectors.toList());
    }

    public MenuDTO pojoToDto(MenuPOJO menuPojo){
        return modelMapper.map(menuPojo, MenuDTO.class);
    }

    public List<MenuDTO> pojoToDto(List<MenuPOJO> menuPojo){
        return menuPojo.stream().map(x -> pojoToDto(x)).collect(Collectors.toList());
    }
}