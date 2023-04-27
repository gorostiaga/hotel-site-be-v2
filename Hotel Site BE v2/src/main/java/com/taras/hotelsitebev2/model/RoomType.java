package com.taras.hotelsitebev2.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "room_types")
public class RoomType extends BaseEntity {

    @Column(name="name")
    private String name;

    @Column(name="price_per_night")
    private Double pricePerNight;

    @OneToMany(mappedBy = "roomType")
    @JsonIgnore
    private Set<Room> rooms;
}
