package com.backend.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.backend.converters.interfaces.IUserConverter;
import com.backend.daos.IAddressDao;
import com.backend.daos.IUserDAO;
import com.backend.dtos.UserDTO;
import com.backend.pojos.UserPOJO;
import com.backend.services.interfaces.IUserService;

@Service
@Transactional
public class UserService implements IUserService{

    @Autowired
    private IUserDAO userDAO;

    @Autowired
    private IAddressDao addressDao;

    @Autowired
    private IUserConverter userConverter;

    @Override
    public UserPOJO addUser(UserDTO user) {
        // StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();

        // if(stackTrace.length >= 3){
        //     StackTraceElement caller = stackTrace[2];
        //     StackTraceElement currMethod = stackTrace[1];
        //     System.out.println("in "+getClass() + ", "+currMethod.getMethodName());System.out.println("Called from "+ caller.getClassName() + ", "+caller.getMethodName());
        // }
        
        UserPOJO persistedUser = userConverter.dtoToPojo(user);
        persistedUser = userDAO.save(persistedUser);
        
        return persistedUser;
    }

    @Override
    public List<UserDTO> allUsers() {
        return userConverter.pojoToDto(userDAO.findAll());
    }
    
    @Override
    public UserDTO userById(Long userId){
        return userConverter.pojoToDto(userDAO.findById(userId).orElse(null));
    }

    
}
