package com.backend.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.backend.config.JwtService;
import com.backend.dtos.OrderDto;
import com.backend.dtos.OrderItemsDTO;
import com.backend.services.interfaces.IOrderService;


@RestController
@RequestMapping("/order")
@CrossOrigin(origins = "*")
public class OrderController {

    @Autowired
    private IOrderService orderService;

    @Autowired
    private JwtService jwtService;

    @PostMapping("/add-Order")
    public OrderDto addOrder(@RequestBody OrderDto orderDto) {
    	System.out.println( orderDto.toString());
        return orderService.addOrder(orderDto);
    }
    
    @GetMapping("/get-orders-by-userid/{token}")
    
    	public List<OrderDto> getOrders(@PathVariable String token)
    	{
    	  String email=jwtService.extractUserName(token);
    	  
    		return orderService.getOrders(email);
    	}
    
    @GetMapping("/get-order-by-orderId/{orderId}")
    public  List<OrderItemsDTO> getOrderItemsByOrderId(@PathVariable Long orderId)   
    {
    	return orderService.getOrderItemsByOrderId(orderId);
    }
    
    @DeleteMapping("/delete-order-record/{orderId}")
    public String deleteOrderRecord(@PathVariable Long orderId)
    {
    	return orderService.deleteOrderRecord(orderId);
    }
    
    @GetMapping("/get-all-orders")
    public List<OrderDto> getAllOrders()
    {
    	return orderService.getAllOrders();
    	
    }
    
    @PutMapping("/update-status/{orderId}/{orderstatus}")
    public String updateStatus(@PathVariable Long orderId,@PathVariable String orderstatus)
    {
    	return orderService.updateStatus(orderId,orderstatus);
    }

}
