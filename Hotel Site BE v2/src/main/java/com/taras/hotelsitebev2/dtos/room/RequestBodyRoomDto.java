package com.taras.hotelsitebev2.dtos.room;

import com.taras.hotelsitebev2.dtos.DtoInterface;
import com.taras.hotelsitebev2.model.RoomImage;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class RequestBodyRoomDto implements DtoInterface {

    private String name;
    private Integer beds;
    private Integer minPeople;
    private Integer maxPeople;
    private String description;
    private Set<RoomImage> roomImages = new HashSet<>();
    private String roomTypeName;
}
