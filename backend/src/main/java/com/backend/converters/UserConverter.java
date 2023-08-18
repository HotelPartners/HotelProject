package com.backend.converters;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.backend.converters.interfaces.IUserConverter;
import com.backend.daos.IAddressDao;
import com.backend.daos.IUserDAO;
import com.backend.dtos.UserDTO;

import com.backend.pojos.UserPOJO;

@Component
public class UserConverter implements IUserConverter{

    @Autowired
    private IUserDAO userDAO;

    @Autowired
    private IAddressDao addressDAO;

    @Override
    public UserPOJO dtoToPojo(UserDTO userDTO) {
        UserPOJO userPOJO = new UserPOJO();
        userPOJO.setUserId(userDTO.getUserId());
        userPOJO.setFirstName(userDTO.getFirstName());
        userPOJO.setLastName(userDTO.getLastName());
        userPOJO.setUserEmail(userDTO.getUserEmail());
        userPOJO.setRole(userDTO.getRole());
        userPOJO.setMobileNumber(userDTO.getMobileNumber());
        userPOJO.setPassword(userDTO.getPassword());
        userPOJO.setUserImage(userDTO.getUserImage());
        return userPOJO;
    }

    @Override
    public List<UserPOJO> dtoToPojo(List<UserDTO> userDTOs) {
        return userDTOs.stream().map(x -> dtoToPojo(x)).collect(Collectors.toList());
    }

    @Override
    public UserDTO pojoToDto(UserPOJO userPOJO) {
        UserDTO userDTO =  new UserDTO();
        userDTO.setUserId(userPOJO.getUserId());
        userDTO.setFirstName(userPOJO.getFirstName());
        userDTO.setLastName(userPOJO.getLastName());
        userDTO.setUserEmail(userPOJO.getUserEmail());
        userDTO.setRole(userPOJO.getRole());
        userDTO.setMobileNumber(userPOJO.getMobileNumber());
        userDTO.setPassword(userPOJO.getPassword());
        userDTO.setUserImage(userPOJO.getUserImage());
        
        return userDTO;
    }

    @Override
    public List<UserDTO> pojoToDto(List<UserPOJO> userPOJOs) {
        return userPOJOs.stream().map(x -> pojoToDto(x)).collect(Collectors.toList());
    }
    
}
