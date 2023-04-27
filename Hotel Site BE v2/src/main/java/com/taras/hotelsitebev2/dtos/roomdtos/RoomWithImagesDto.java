package com.taras.hotelsitebev2.dtos.roomdtos;

import com.taras.hotelsitebev2.dtos.DtoInterface;
import com.taras.hotelsitebev2.model.Booking;
import com.taras.hotelsitebev2.model.RoomImage;
import com.taras.hotelsitebev2.model.RoomType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class RoomWithImagesDto implements DtoInterface, Serializable {

    private Integer id;
    private String name;
    private Integer beds;
    private  Integer minPeople;
    private  Integer maxPeople;
    private  String description;
    private Set<RoomImage> roomImages = new HashSet<>();
    private RoomType roomType;
    private Set<Booking> bookings = new HashSet<>();
}
