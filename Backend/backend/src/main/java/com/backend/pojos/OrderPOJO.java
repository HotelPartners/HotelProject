package com.backend.pojos;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.backend.pojos.enums.OrderStatus;
import com.backend.pojos.enums.PaymentType;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "orders")
public class OrderPOJO {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "order_id")
	private Long orderId;

	@ManyToOne
	@JoinColumn(name = "user_id")
	private UserPOJO user;

	@OneToOne
	private AddressPOJO addressPOJO;

	@Column(name = "order_time")
	private LocalDateTime orderTime;

	@Column(name = "payment_method")
	@Enumerated(EnumType.STRING)
	private PaymentType paymentMenthod;
	
	@Column(name = "order_status")
	@Enumerated(EnumType.STRING)
	private OrderStatus orderStatus;

	@Column(name = "total_price")
	private Long totalPrice;

	@Column(name = "total_quantity")
	private Long totalQuantity;

	@OneToMany(mappedBy = "orderPOJO", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<OrderItemsPojo> items = new ArrayList<>();

	public void addOrder(OrderItemsPojo orderItemsPojo) {
		this.items.add(orderItemsPojo);
		orderItemsPojo.setOrderPOJO(this);
	}

}
