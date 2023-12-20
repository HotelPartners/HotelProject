package com.backend.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.backend.converters.interfaces.IUserConverter;
import com.backend.daos.IAddressDao;
import com.backend.daos.IUserDAO;
import com.backend.dtos.LoginDTO;
import com.backend.dtos.UserDTO;
import com.backend.pojos.UserPOJO;
import com.backend.pojos.enums.UserRole;
// import com.backend.pojos.enums.UserRole;
import com.backend.services.interfaces.IUserService;

@Service
@Transactional
public class UserService implements IUserService {

    @Autowired
    private IUserDAO userDAO;

    @Autowired
    private IAddressDao addressDao;

    @Autowired
    private IUserConverter userConverter;
    
    @Autowired
    private PasswordEncoder encoder;

    @Override
    public UserPOJO addUser(UserDTO user) {

        if (user.getRole() == null) {
            user.setRole(UserRole.valueOf("CUSTOMER"));
        }
        UserPOJO persistedUser = userConverter.dtoToPojo(user);
        persistedUser = userDAO.save(persistedUser);

        return persistedUser;
    }

    @Override
    public List<UserDTO> allUsers() {
        return userConverter.pojoToDto(userDAO.findAll());
    }

    @Override
    public List<UserDTO> allCustomers() {

    	
    	List<UserPOJO> a = userDAO.findByRole(UserRole.valueOf("CUSTOMER"));
    	for (UserPOJO u : a) {
			System.out.println(u.getFirstName()+"-------------*****************");
		}
    	
        return userConverter.pojoToDto(a);
    }

    @Override
    public UserDTO userByEmail(String userEmail) {
        UserDTO usr= userConverter.pojoToDto(userDAO.findByUserEmail(userEmail).get());
         System.out.println(usr.toString());
        return usr;
    }

    @Override
    public UserDTO userByEmailAndPassword(LoginDTO loginDTO) {  
        // System.out.println(loginDTO.getPassword() + loginDTO.getUserEmail());
        UserPOJO userPOJO = userDAO.findByUserEmailAndPassword(loginDTO.getUserEmail(), loginDTO.getPassword());
        if (null != userPOJO) {

            return userConverter.pojoToDto(userPOJO);
        } else {
            return null;
        }
    }

    @Override
    public UserDTO updateUserProfile(UserDTO userDTO, String userEmail) {
        UserPOJO userPOJO = userDAO.findByUserEmail(userEmail).get();
    	System.out.println("in userservice "+userPOJO.toString());

        if (userPOJO != null) {
            // userPOJO.setUserId(userID);
            userPOJO.setFirstName(userDTO.getFirstName());
            userPOJO.setLastName(userDTO.getLastName());
            userPOJO.setRole(UserRole.valueOf("CUSTOMER"));
            userPOJO.setMobileNumber(userDTO.getMobileNumber());
            userPOJO.setUserEmail(userDTO.getUserEmail());
            userPOJO.setPassword(encoder.encode(userDTO.getPassword()));
        }
        userDAO.save(userPOJO);
        return userConverter.pojoToDto(userPOJO); 
    }

    @Override
    public ResponseEntity<String> IsUserValid(String email) {
        UserPOJO user = userDAO.findByUserEmail(email).orElse(null);

        if (user != null) {
            return ResponseEntity.ok(user.getRole().toString());
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User not found");
        }
    }


}
