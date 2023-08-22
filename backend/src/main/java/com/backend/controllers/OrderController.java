package com.backend.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.backend.dtos.OrderDTO;
import com.backend.services.interfaces.IOrderService;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private IOrderService orderService;

    @PostMapping("/{userId}")
    public OrderDTO addOrder(@RequestBody OrderDTO orderDTO, @RequestBody List<Long> itemIds, @PathVariable Long userId){
        return orderService.addOrder(orderDTO, itemIds, userId);
    }
}
