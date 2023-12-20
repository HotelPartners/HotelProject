package com.backend.converters;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.backend.converters.interfaces.IOrderConverter;
import com.backend.dtos.OrderDto;
import com.backend.pojos.OrderPOJO;

@Component
public class OrderConverter implements IOrderConverter {

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public OrderPOJO dtoToPojo(OrderDto orderDTO) {
        return modelMapper.map(orderDTO, OrderPOJO.class);
    }

    @Override
    public List<OrderPOJO> dtoToPojo(List<OrderDto> orderDTOs) {
        return orderDTOs.stream().map(x -> dtoToPojo(x)).collect(Collectors.toList());
    }

    @Override
    public OrderDto pojoToDto(OrderPOJO orderPOJO) {
        return modelMapper.map(orderPOJO, OrderDto.class);
    }

    @Override
    public List<OrderDto> pojoToDto(List<OrderPOJO> orderPOJOs) {
        return orderPOJOs.stream().map(x -> pojoToDto(x)).collect(Collectors.toList());
    }

}
