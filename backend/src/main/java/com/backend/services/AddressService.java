package com.backend.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.backend.converters.interfaces.IAddressConverter;
import com.backend.daos.IAddressDao;
import com.backend.daos.IUserDAO;
import com.backend.dtos.AddressDTO;
import com.backend.pojos.AddressPOJO;
import com.backend.pojos.UserPOJO;
import com.backend.services.interfaces.IAddressService;

@Service
@Transactional
public class AddressService implements IAddressService {

    @Autowired
    private IAddressDao addressDao;

    @Autowired
    private IUserDAO userDAO;

    @Autowired
    private IAddressConverter addressConverter;

    @Override
    public AddressPOJO addAddress(AddressDTO address, Long userId) {
        UserPOJO user = userDAO.findById(userId).get();
        AddressPOJO persistedAddress = addressConverter.dtoToPojo(address);
        if (persistedAddress.addUser(user)) {
            persistedAddress = addressDao.save(persistedAddress);

        }
        // if(null != persistedAddress){
        // }
        return persistedAddress;
    }

}
