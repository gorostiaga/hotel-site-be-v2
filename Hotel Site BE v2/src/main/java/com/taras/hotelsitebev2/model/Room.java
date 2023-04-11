package com.taras.hotelsitebev2.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class Room implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private long roomId;

    @Column(name = "name")
    private String name;

    @Column(name = "min_people")
    private  Integer minPeople;

    @Column(name = "max_people")
    private  Integer maxPeople;

    @Column(name = "description")
    private  String description;

    @Column(name = "price_night_person")
    private double priceNighPerson;

    //uni-directional
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name="room_id")
    private Set<RoomImage> roomImages = new HashSet<>();

    @ManyToOne
    private RoomType roomType;

    @OneToMany(mappedBy = "room")
    private Set<Booking> bookings = new HashSet<>();


    //TODO add all the common relations
    //TODO write the constructor

}
