package com.taras.hotelsitebev2.converters;

import com.taras.hotelsitebev2.dtos.roomdtos.RoomsDto;
import com.taras.hotelsitebev2.model.Room;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class RoomToRoomsDto implements Converter<Room, RoomsDto> {

    @Override
    public RoomsDto convert(Room source) {
        return null;
    }
}
