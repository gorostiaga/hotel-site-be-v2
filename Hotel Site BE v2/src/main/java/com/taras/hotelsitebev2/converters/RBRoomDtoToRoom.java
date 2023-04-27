package com.taras.hotelsitebev2.converters;

import com.taras.hotelsitebev2.dtos.roomdtos.RequestBodyRoomDto;
import com.taras.hotelsitebev2.model.Room;
import com.taras.hotelsitebev2.services.RoomTypeService;
import lombok.Synchronized;
import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

@Component
public class RBRoomDtoToRoom implements Converter<RequestBodyRoomDto, Room> {

    private final RoomTypeService roomTypeService;

    public RBRoomDtoToRoom(RoomTypeService roomTypeService) {
        this.roomTypeService = roomTypeService;
    }

    @Synchronized
    @Nullable
    @Override
    public Room convert(RequestBodyRoomDto source) {

        if (source == null) {
            return null;
        }

        final Room room = new Room();

        room.setName(source.getName());
        room.setBeds(source.getBeds());
        room.setMinPeople(source.getMinPeople());
        room.setMaxPeople(source.getMaxPeople());
        room.setDescription(source.getDescription());
        room.setRoomImages(source.getRoomImages());
        room.setRoomType(roomTypeService.getByName(source.getRoomTypeName()));
        room.setBookings(null);

        return room;
    }
}
