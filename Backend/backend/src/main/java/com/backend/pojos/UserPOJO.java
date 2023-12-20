package com.backend.pojos;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.backend.pojos.enums.UserRole;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@Entity
@ToString
@Builder
@Table(name = "users")
public class UserPOJO implements UserDetails {

    public UserPOJO(Long userId, String firstName, String lastName, UserRole role, String userEmail,
			String mobileNumber, Set<AddressPOJO> addresses, LocalDate registeredDate, String password,
			 List<TableReservationPOJO> reservedTables, Set<OrderPOJO> orders) {
		super();
		this.userId = userId; 
		this.firstName = firstName;
		this.lastName = lastName;
		this.role = role;
		this.userEmail = userEmail;
		this.mobileNumber = mobileNumber;
		this.addresses = addresses;
		this.registeredDate = registeredDate;
		this.password = password;
		this.reservedTables = reservedTables;
		this.orders = orders;
	}

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Long userId;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Enumerated(EnumType.STRING)
    private UserRole role;

    @Column(name = "email", unique = true)
    private String userEmail;

    @Column(name = "mob_no", unique = true)
    private String mobileNumber;

    @OneToMany(mappedBy = "userPOJO", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<AddressPOJO> addresses = new HashSet<AddressPOJO>();

    public Boolean addAddress(AddressPOJO addressPOJO) {
        addressPOJO.setUserPOJO(this);
        return this.addresses.add(addressPOJO);
    }

    public Boolean removeAddress(AddressPOJO addressPOJO) {
        addressPOJO.setUserPOJO(null);
        return this.addresses.remove(addressPOJO);
    }

    @Column(name = "reg_date")
    private LocalDate registeredDate = LocalDate.now();

    @Column(name = "password")
    private String password;

  



    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<TableReservationPOJO> reservedTables = new ArrayList<>();

    public void addTableReservation(TableReservationPOJO liveTableReservationPOJO) {
        reservedTables.add(liveTableReservationPOJO);
        liveTableReservationPOJO.setUser(this);
    }

    public void removeTableReservation(TableReservationPOJO liveTableReservationPOJO) {
        reservedTables.remove(liveTableReservationPOJO);
        liveTableReservationPOJO.setUser(null);
    }

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<OrderPOJO> orders = new HashSet<>();

    private String toStr() {
        return "UserPOJO [userId=" + userId + ", firstName=" + firstName + ", lastName=" + lastName + ", role=" + role
                + ", userEmail=" + userEmail + ", mobileNumber=" + mobileNumber + ", addresses=" + addresses
                + ", registeredDate=" + registeredDate + "]";
    }

  

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return List.of(new SimpleGrantedAuthority(role.name()));
	}

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return userEmail;
	}

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}
}
