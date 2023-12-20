package com.backend.converters;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.backend.converters.interfaces.ILoginConverter;
import com.backend.dtos.LoginDTO;
import com.backend.pojos.UserPOJO;

@Component
public class LoginConverter implements ILoginConverter{

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public UserPOJO dtoToPojo(LoginDTO loginDTO) {
        return modelMapper.map(loginDTO, UserPOJO.class);
    }

    @Override
    public List<UserPOJO> dtoToPojo(List<LoginDTO> loginDTOs) {
        return loginDTOs.stream().map(x -> dtoToPojo(x)).collect(Collectors.toList());
    }

    @Override
    public LoginDTO pojoToDto(UserPOJO userPOJO) {
        return modelMapper.map(userPOJO, LoginDTO.class);
    }

    @Override
    public List<LoginDTO> pojoToDto(List<UserPOJO> userPOJOs) {
        return userPOJOs.stream().map(x -> pojoToDto(x)).collect(Collectors.toList());
    }
    
}
