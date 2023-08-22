package com.backend.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.backend.converters.interfaces.IOrderConverter;
import com.backend.daos.IMenuDAO;
import com.backend.daos.IOrderDAO;
import com.backend.daos.IUserDAO;
import com.backend.dtos.OrderDTO;
import com.backend.pojos.OrderPOJO;
import com.backend.pojos.UserPOJO;
import com.backend.services.interfaces.IOrderService;

@Service
@Transactional
public class OrderService implements IOrderService {

    @Autowired
    private IOrderDAO orderDAO;
    @Autowired
    private IOrderConverter orderConverter;
    @Autowired
    private IMenuDAO menuDAO;
    @Autowired
    private IUserDAO userDAO;

    @Override
    public OrderDTO addOrder(OrderDTO orderDTO, List<Long> itemIds, Long userId) {
        OrderPOJO orderPOJO = orderConverter.dtoToPojo(orderDTO);
        orderPOJO = orderDAO.save(orderPOJO);
        UserPOJO userPOJO = userDAO.findById(userId).get();
        for (Long itemId : itemIds) {
            orderPOJO.addItem(menuDAO.findById(itemId).get());
        }
        orderPOJO.setUser(userPOJO);
        return orderConverter.pojoToDto(orderPOJO);
    }

}
