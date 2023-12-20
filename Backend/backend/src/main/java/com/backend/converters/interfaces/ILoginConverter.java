package com.backend.converters.interfaces;

import java.util.List;

import com.backend.dtos.LoginDTO;
import com.backend.pojos.UserPOJO;

public interface ILoginConverter {
    public UserPOJO dtoToPojo(LoginDTO loginDTO);

    public List<UserPOJO> dtoToPojo(List<LoginDTO> loginDTOs);

    public LoginDTO pojoToDto(UserPOJO userPOJO);

    public List<LoginDTO> pojoToDto(List<UserPOJO> userPOJOs);
}
