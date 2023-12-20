package com.backend.converters.interfaces;

import java.util.List;

import org.springframework.stereotype.Component;

import com.backend.dtos.UserDTO;
import com.backend.pojos.UserPOJO;

public interface IUserConverter {
    public UserPOJO dtoToPojo(UserDTO userDTO);
    public List<UserPOJO> dtoToPojo(List<UserDTO> userDTOs);
    public UserDTO pojoToDto(UserPOJO userPOJO);
    public List<UserDTO> pojoToDto(List<UserPOJO> userPOJOs);
}
