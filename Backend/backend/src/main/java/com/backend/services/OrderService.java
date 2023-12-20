package com.backend.services;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.backend.converters.AddressConverter;
import com.backend.converters.interfaces.IOrderConverter;
import com.backend.daos.IAddressDao;
import com.backend.daos.IMenuDAO;
import com.backend.daos.IOrderDAO;
import com.backend.daos.IUserDAO;
import com.backend.dtos.AddressDTO;
import com.backend.dtos.OrderDto;
import com.backend.dtos.OrderItemsDTO;
import com.backend.pojos.AddressPOJO;
import com.backend.pojos.OrderItemsPojo;
import com.backend.pojos.OrderPOJO;
import com.backend.pojos.UserPOJO;
import com.backend.pojos.enums.OrderStatus;
import com.backend.pojos.enums.PaymentType;
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
	
	@Autowired
	private IAddressDao addressDao;
	
	@Autowired 
	private ModelMapper mapper;

	@Override
	public OrderDto addOrder(OrderDto orderDto) {
	    OrderPOJO orderpojo = new OrderPOJO();

	    UserPOJO userPOJO = userDAO.findById(orderDto.getUserId()).orElse(null);
	    AddressPOJO addpojo = userPOJO.getAddresses().stream()
	            .filter(address -> address.getAddressId() == orderDto.getAddressId())
	            .findFirst()
	            .orElse(null);

	    if (userPOJO != null && addpojo != null) {
	        orderpojo.setAddressPOJO(addpojo);
	        orderpojo.setUser(userPOJO);
	        orderpojo.setPaymentMenthod(PaymentType.valueOf(orderDto.getPaymentType()));
	        orderpojo.setOrderTime(LocalDateTime.now());
	        orderpojo.setTotalPrice(orderDto.getTotalprice()); 
	        orderpojo.setTotalQuantity(orderDto.getTotalqty());
	        orderpojo.setOrderStatus(OrderStatus.valueOf("PROCESSING"));

	        List<OrderItemsPojo> orderItems = addorderconverter(orderDto.getItemsDTOs(), orderpojo);
	        orderpojo.setItems(orderItems);

	        orderDAO.save(orderpojo);
	        return orderDto;
	    } else {
	        return null;
	    }
	}

	private List<OrderItemsPojo> addorderconverter(List<OrderItemsDTO> orderdto, OrderPOJO orderpojo) {
	    List<OrderItemsPojo> orderItemPojo = new ArrayList<>();

	    for (OrderItemsDTO od : orderdto) {
	        OrderItemsPojo oo = new OrderItemsPojo();
	        oo.setItemName(od.getItemName());
	        oo.setMealchoice(od.getMealchoice());
	        oo.setPrice(od.getPrice());
	        oo.setQuantity(od.getQuantity());
	    
	        oo.setOrderPOJO(orderpojo);

	        orderItemPojo.add(oo);
	    }

	    return orderItemPojo;
	}

	@Override
	public List<OrderDto> getOrders(String email)
	{
		UserPOJO userpojo=userDAO.findByUserEmail(email).get();
		Set<OrderPOJO> orderpojo=userpojo.getOrders();
		List<OrderPOJO> list=orderpojo.stream().collect(Collectors.toList());
		
		return orderConverter(list);
		
	}
	
	private List<OrderDto> orderConverter(List<OrderPOJO> orderpojo)
	{
		List<OrderDto> orderdto=new ArrayList<>();
		for(int i=0;i<orderpojo.size();i++)
		{
			OrderDto order=new OrderDto();
			AddressDTO add=new AddressConverter().pojoToDto(orderpojo.get(i).getAddressPOJO());
			order.setOrderId(orderpojo.get(i).getOrderId());
			order.setUserId(orderpojo.get(i).getUser().getUserId());
			order.setAddressDto(add);
			order.setPaymentType(orderpojo.get(i).getPaymentMenthod().name());
			order.setTotalprice(orderpojo.get(i).getTotalPrice());
			order.setTotalqty(orderpojo.get(i).getTotalQuantity());
			//order.setItemsDTOs(ItemspojoToItemDtoConverter(orderpojo.get(i).getItems()));
			order.setDate(orderpojo.get(i).getOrderTime());
			order.setOrderstatus(orderpojo.get(i).getOrderStatus().name());
			orderdto.add(order);
			
		}
		return orderdto;
		
	}

	@Override
	public List<OrderItemsDTO> getOrderItemsByOrderId(Long orderId)
	{
		return ItemspojoToItemDtoConverter(orderDAO.findById(orderId).get().getItems());
	}
	
	private List<OrderItemsDTO> ItemspojoToItemDtoConverter(List<OrderItemsPojo> items) {
	
		List<OrderItemsDTO> dtos=new ArrayList<>();
		
		for (OrderItemsPojo item : items) {
			OrderItemsDTO dto=new OrderItemsDTO();
			dto.setItemId(item.getItemId());
			dto.setItemName(item.getItemName());
			dto.setMealchoice(item.getMealchoice());
			dto.setPrice(item.getPrice());
			dto.setQuantity(item.getQuantity());
			dtos.add(dto);
		}
		
		return dtos;
	}
	
	public String deleteOrderRecord(Long orderId)
	{
		 try {
			 orderDAO.deleteById(orderId);
			 return "success";
		 }
		 catch(Exception e)
		 {
			 return "error";
		 }
	}

	@Override
	public List<OrderDto> getAllOrders() {
		List<OrderPOJO> orderpojo = orderDAO.findAll();
		
		return orderConverter(orderpojo);
	}

	@Override
	public String updateStatus(Long orderId,String orderstatus) {
		
		OrderPOJO orderpojo=orderDAO.findById(orderId).get();
		orderpojo.setOrderStatus(OrderStatus.valueOf(orderstatus));
		try {
         orderDAO.save(orderpojo);
         return "success";
		}catch(Exception e)
		{
			return "error";
		}
		
 	
	}

}
