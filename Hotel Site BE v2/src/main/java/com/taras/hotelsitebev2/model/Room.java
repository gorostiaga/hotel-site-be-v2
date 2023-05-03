package com.taras.hotelsitebev2.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "rooms")
public class Room extends BaseEntity {

    @Column(name = "name")
    private String name;

    @Column(name = "beds")
    private Integer beds;

    @Column(name = "min_people")
    private  Integer minPeople;

    @Column(name = "max_people")
    private  Integer maxPeople;

    @Column(name = "description")
    private  String description;

    //uni-directional
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name="room_id")
    private Set<RoomImage> roomImages = new HashSet<>();

    //JsonIgnore is for avoiding an infinite loop bw the bi-direction at the
    //moment to turn this POJO into a JSON
    @ManyToOne
    @JoinColumn(name = "room_type_id")
    @JsonIgnore
    private RoomType roomType;

    @OneToMany(mappedBy = "room")
    @JsonIgnore
    private Set<Booking> bookings = new HashSet<>();

    public Room(String name, Integer beds, Integer minPeople, Integer maxPeople, String description, Set<RoomImage> roomImages, RoomType roomType) {
        this.name = name;
        this.beds = beds;
        this.minPeople = minPeople;
        this.maxPeople = maxPeople;
        this.description = description;
        this.roomImages = roomImages;
        this.roomType = roomType;
        this.bookings = null;
    }
}
