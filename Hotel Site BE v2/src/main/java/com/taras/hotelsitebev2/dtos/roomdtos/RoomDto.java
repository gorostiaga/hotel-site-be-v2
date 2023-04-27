package com.taras.hotelsitebev2.dtos.roomdtos;

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
public class RoomDto implements DtoInterface, Serializable {

    private Integer id;
    private String name;
    private Integer beds;
    private Integer minPeople;
    private Integer maxPeople;
    private Double priceNightPerson;
    private String masterImage;

}
