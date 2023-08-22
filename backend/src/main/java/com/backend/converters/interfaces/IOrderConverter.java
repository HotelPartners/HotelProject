package com.backend.converters.interfaces;

import java.util.List;

import com.backend.dtos.OrderDTO;
import com.backend.pojos.OrderPOJO;


public interface IOrderConverter {
    public OrderPOJO dtoToPojo(OrderDTO orderDTO);

    public List<OrderPOJO> dtoToPojo(List<OrderDTO> orderDTOs);

    public OrderDTO pojoToDto(OrderPOJO orderPOJO);

    public List<OrderDTO> pojoToDto(List<OrderPOJO> orderPOJOs);
}
