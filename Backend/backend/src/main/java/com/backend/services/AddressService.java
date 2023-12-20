package com.backend.services;


import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

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
    public AddressDTO addAddress(AddressDTO address, String userEmail) {
        UserPOJO user = userDAO.findByUserEmail(userEmail).get();
        AddressPOJO persistedAddress = addressConverter.dtoToPojo(address);
//        persistedAddress.setUserPOJO(user);
        user.addAddress(persistedAddress);
        persistedAddress = addressDao.save(persistedAddress);

        return addressConverter.pojoToDto(persistedAddress);
    }

    @Override
    public List<AddressDTO> getAddress(String userEmail)
    {
        UserPOJO user =userDAO.findByUserEmail(userEmail).get();
        Set<AddressPOJO> addressPOJOs=user.getAddresses();
        return addressConverter.pojoToDto(addressPOJOs.stream().collect(Collectors.toList()));
    }

}
