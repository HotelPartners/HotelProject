package com.backend.converters;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.backend.converters.interfaces.IOrderConverter;
import com.backend.dtos.OrderDTO;
import com.backend.pojos.OrderPOJO;

@Component
public class OrderConverter implements IOrderConverter {

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public OrderPOJO dtoToPojo(OrderDTO orderDTO) {
        return modelMapper.map(orderDTO, OrderPOJO.class);
    }

    @Override
    public List<OrderPOJO> dtoToPojo(List<OrderDTO> orderDTOs) {
        return orderDTOs.stream().map(x -> dtoToPojo(x)).collect(Collectors.toList());
    }

    @Override
    public OrderDTO pojoToDto(OrderPOJO orderPOJO) {
        return modelMapper.map(orderPOJO, OrderDTO.class);
    }

    @Override
    public List<OrderDTO> pojoToDto(List<OrderPOJO> orderPOJOs) {
        return orderPOJOs.stream().map(x -> pojoToDto(x)).collect(Collectors.toList());
    }

}
