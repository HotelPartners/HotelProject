package com.backend.pojos;

import java.time.LocalDate;
import java.time.LocalTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.CollectionId;

import com.backend.pojos.enums.EventDuration;
import com.backend.pojos.enums.EventVenueType;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "event_venue")
public class EventVenuePOJO {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "room_id")
    private Long roomId;

    @Column(name = "accomodation_count")
    private Long accomodationCount;

    @Column(name = "event_venue_type")
    private EventVenueType eventVenueType;

    @Column(name = "room_image")
    private byte[] roomImage;

    @Column(name = "price")
    private Double price;

}
