package com.backend.services.interfaces;

import java.util.List;

import com.backend.dtos.OrderDTO;

public interface IOrderService {
    OrderDTO addOrder(OrderDTO orderDTO, List<Long> itemIds, Long userId);
}
