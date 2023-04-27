package com.taras.hotelsitebev2.converters;

import com.taras.hotelsitebev2.dtos.roomdtos.RoomDto;
import com.taras.hotelsitebev2.model.Room;
import com.taras.hotelsitebev2.model.RoomImage;
import lombok.Synchronized;
import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;


@Component
public class RoomToRoomDto implements Converter<Room, RoomDto> {

    @Synchronized
    @Nullable
    @Override
    public RoomDto convert(Room source) {
        if (source == null) {
            return null;
        }

        RoomImage image = source.getRoomImages()
                .stream()
                .filter(roomImage -> roomImage.getDescription().equals("master"))
                .findFirst()
                .orElse(null);

        final RoomDto dto = new RoomDto();

        dto.setId(source.getId());
        dto.setName(source.getName());
        dto.setBeds(source.getBeds());
        dto.setMinPeople(source.getMinPeople());
        dto.setMaxPeople(source.getMaxPeople());
        dto.setPriceNightPerson(source.getRoomType().getPricePerNight());
        dto.setMasterImage(image.getFilePath());

//        Set<RoomImage> images = source.getRoomImages();
//        for (RoomImage image : images) {
//            if (image.getDescription().equals("master")) {
//                masterImageUrl = image.getFilePath();
//                break;
//            }
//        }
        return dto;
    }
}
