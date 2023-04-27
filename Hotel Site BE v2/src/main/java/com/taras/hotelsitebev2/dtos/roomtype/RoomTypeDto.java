package com.taras.hotelsitebev2.dtos.roomtype;

import com.taras.hotelsitebev2.dtos.DtoInterface;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class RoomTypeDto implements DtoInterface, Serializable {

    private Integer id;
    private String name;
    private Double pricePerNight;
    //TODO include Set<Room> rooms; when required
}
