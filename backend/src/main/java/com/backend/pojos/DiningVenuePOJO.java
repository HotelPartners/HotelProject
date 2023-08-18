package com.backend.pojos;

import java.util.ArrayList;
import java.util.List;

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


import com.backend.pojos.enums.DiningVenueType;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

//Parent Table for DiningTablePOJO

@Setter
@Getter
@NoArgsConstructor
@Entity
@Table(name = "dining_venue")
public class DiningVenuePOJO{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "room_id")
    private Long roomId;

    @Column(name = "accomodation_count")
    private Long accomodationCount;

    // @Column(name = "dining_venue_type")
    // @Enumerated(EnumType.STRING)
    // private DiningVenueType diningVenueType;

    @Column(name = "room_image")
    private byte[] roomImage;

    // @OneToMany(mappedBy = "diningVenue", cascade = CascadeType.ALL, orphanRemoval = true)
    // private List<DiningTablePOJO> diningTables = new ArrayList<>();

}
