package com.taras.hotelsitebev2.converters;

import com.taras.hotelsitebev2.dtos.roomtype.RoomTypeDto;
import com.taras.hotelsitebev2.model.RoomType;
import lombok.Synchronized;
import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

@Component
public class RoomTypeToRoomTypeDto implements Converter<RoomType, RoomTypeDto> {

    @Synchronized
    @Nullable
    @Override
    public RoomTypeDto convert(RoomType source) {

        if (source == null) {
            return null;
        }

        final RoomTypeDto roomTypeDto = new RoomTypeDto();

        roomTypeDto.setId(source.getId());
        roomTypeDto.setName(source.getName());
        roomTypeDto.setPricePerNight(source.getPricePerNight());

        return roomTypeDto;
    }
}
