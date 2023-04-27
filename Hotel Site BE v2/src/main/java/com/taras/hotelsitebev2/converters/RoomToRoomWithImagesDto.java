package com.taras.hotelsitebev2.converters;

import com.taras.hotelsitebev2.dtos.room.RoomWithImagesDto;
import com.taras.hotelsitebev2.model.Room;
import lombok.Synchronized;
import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

@Component
public class RoomToRoomWithImagesDto implements Converter<Room, RoomWithImagesDto> {

    @Synchronized
    @Nullable
    @Override
    public RoomWithImagesDto convert(Room source) {

        if (source == null) {
            return null;
        }

        final RoomWithImagesDto roomWithImagesDto = new RoomWithImagesDto();

        roomWithImagesDto.setId(source.getId());
        roomWithImagesDto.setName(source.getName());
        roomWithImagesDto.setBeds(source.getBeds());
        roomWithImagesDto.setMinPeople(source.getMinPeople());
        roomWithImagesDto.setMaxPeople(source.getMaxPeople());
        roomWithImagesDto.setDescription(source.getDescription());
        roomWithImagesDto.setRoomImages(source.getRoomImages());
        roomWithImagesDto.setRoomType(source.getRoomType());
        roomWithImagesDto.setBookings(source.getBookings());

        return roomWithImagesDto;
    }
}
