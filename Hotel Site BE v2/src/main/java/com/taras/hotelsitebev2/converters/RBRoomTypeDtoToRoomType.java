package com.taras.hotelsitebev2.converters;

import com.taras.hotelsitebev2.dtos.roomtype.RequestBodyRoomTypeDto;
import com.taras.hotelsitebev2.model.RoomType;
import lombok.Synchronized;
import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

@Component
public class RBRoomTypeDtoToRoomType implements Converter<RequestBodyRoomTypeDto, RoomType> {

    @Synchronized
    @Nullable
    @Override
    public RoomType convert(RequestBodyRoomTypeDto source) {

        if (source == null) {
            return null;
        }

        RoomType roomType = new RoomType();
        roomType.setName(source.getName());
        roomType.setPricePerNight((source.getPricePerNight()));

        return roomType;
    }
}
