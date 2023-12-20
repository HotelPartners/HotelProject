package com.backend.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.backend.converters.interfaces.IShopConverter;
import com.backend.daos.IShopDAO;
import com.backend.dtos.ShopDTO;
import com.backend.services.interfaces.IShopService;

@Service
@Transactional
public class ShopService implements IShopService {

    @Autowired
    private IShopDAO shopDAO;
    @Autowired
    private IShopConverter shopConverter;

    @Override
    public ShopDTO addShop(ShopDTO shopDTO) {
        return shopConverter.pojoToDto(shopDAO.save(shopConverter.dtoToPojo(shopDTO)));
    }

}
