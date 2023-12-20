package com.backend.services.interfaces;

import java.util.List;

import com.backend.dtos.OrderDto;
import com.backend.dtos.OrderItemsDTO;

public interface IOrderService
{
    public OrderDto addOrder(OrderDto orderDTO);
    public List<OrderDto> getOrders(String email);
    public List<OrderItemsDTO> getOrderItemsByOrderId(Long orderId);
    public String deleteOrderRecord(Long orderId);
    List<OrderDto> getAllOrders();
    public String updateStatus(Long orderId, String orderstatus);
}
