package com.backend.pojos;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

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

    @Column(name = "order_time")
    private LocalDateTime orderTime;

    @Column(name = "payment_method")
    private PaymentType paymentMenthod;

    @ManyToMany(mappedBy = "orders", fetch = FetchType.LAZY)
    private Set<MenuPOJO> items = new HashSet<>();

    public Boolean addItem(MenuPOJO menuPOJO){
        menuPOJO.getOrders().add(this);
        return this.items.add(menuPOJO);
    }

    public Boolean removeItem(MenuPOJO menuPOJO){
        menuPOJO.getOrders().remove(this);
        return this.items.remove(menuPOJO);
    }
}
