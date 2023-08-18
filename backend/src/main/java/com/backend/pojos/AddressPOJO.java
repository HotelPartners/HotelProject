package com.backend.pojos;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "address")
public class AddressPOJO {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "address_id")
    private Long addressId;

    @Column(name = "address_line")
    private String addressLine;

    @Column(name = "landmark")
    private String landmark;

    @Column(name = "city")
    private String city;

    @Column(name = "pincode")
    private String pincode;

    @ManyToMany(mappedBy = "addresses", fetch = FetchType.LAZY)
    // @JsonBackReference
    private Set<UserPOJO> users = new HashSet<>();

    public Boolean addUser(UserPOJO userPOJO){
        userPOJO.getAddresses().add(this);
        return this.users.add(userPOJO);
    }

    public Boolean removeUser(UserPOJO userPOJO){
        userPOJO.getAddresses().remove(this);
        return this.users.remove(userPOJO);
    }

    @Override
    public String toString(){
        return toStr();
    }

    private String toStr() {
        return "AddressPOJO [addressId=" + addressId + ", addressLine=" + addressLine + ", landmark=" + landmark
                + ", city=" + city + ", pincode=" + pincode + ", users=" + users + "]";
    }

    

}
