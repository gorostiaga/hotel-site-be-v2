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
public class RequestBodyRoomTypeDto implements DtoInterface, Serializable {

    private String name;
    private Double pricePerNight;
}
