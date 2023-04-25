package com.taras.hotelsitebev2.dtos.roomdtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class RoomsItem {
    private Integer id;
    private String name;
    private Integer beds;
    private Integer minPeople;
    private Integer maxPeople;
    private Double priceNightPerson;
    private String masterImage;
}
