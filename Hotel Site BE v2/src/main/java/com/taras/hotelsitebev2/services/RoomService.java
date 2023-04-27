package com.taras.hotelsitebev2.services;

import com.taras.hotelsitebev2.converters.RBRoomDtoToRoom;
import com.taras.hotelsitebev2.converters.RoomToRoomDto;
import com.taras.hotelsitebev2.converters.RoomToRoomWithImagesDto;
import com.taras.hotelsitebev2.dtos.DtoInterface;
import com.taras.hotelsitebev2.dtos.roomdtos.RequestBodyRoomDto;
import com.taras.hotelsitebev2.exceptions.NotFoundException;
import com.taras.hotelsitebev2.model.Room;
import com.taras.hotelsitebev2.repos.RoomRepo;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class RoomService implements ServiceInterface  {

    private final RoomRepo roomRepo;
    private final RoomToRoomDto roomToRoomDto;
    private final RoomToRoomWithImagesDto roomToRoomWithImagesDto;
    private final RBRoomDtoToRoom rbRoomDtoToRoom;

    public RoomService(RoomRepo roomRepo, RoomToRoomDto roomToRoomDto, RoomToRoomWithImagesDto roomToRoomWithImagesDto,
                       RBRoomDtoToRoom rbRoomDtoToRoom) {
        this.roomRepo = roomRepo;
        this.roomToRoomDto = roomToRoomDto;
        this.roomToRoomWithImagesDto = roomToRoomWithImagesDto;
        this.rbRoomDtoToRoom = rbRoomDtoToRoom;
    }

    @Override
    public Map<String, List<DtoInterface>> getList() {

        List<DtoInterface> roomsItems;
        Map <String, List<DtoInterface>> response = new HashMap<>();

        roomsItems = StreamSupport.stream(roomRepo.findAll()
                .spliterator(),false)
                .map(roomToRoomDto::convert)
                .collect(Collectors.toList());

        response.put("rooms", roomsItems);
        return response;
    }

    @Override
    public Map<String, DtoInterface> getById(Integer id) {
        Room room = roomRepo.findById(id).orElse(null);
        if (room == null) {
            throw new NotFoundException("Item no se encuentra - " + id);
        }
        Map<String, DtoInterface> response = new HashMap<>();
        response.put("room", roomToRoomWithImagesDto.convert(room));
        return response;
    }

    @Override
    public void save(DtoInterface dto) {
        RequestBodyRoomDto requestBodyRoomDto = (RequestBodyRoomDto) dto;
        roomRepo.save(rbRoomDtoToRoom.convert(requestBodyRoomDto));
    }

    @Override
    public void update(Integer id, DtoInterface dto) {
        RequestBodyRoomDto requestBodyRoomDto = (RequestBodyRoomDto) dto;
        Room updatedRoom = rbRoomDtoToRoom.convert(requestBodyRoomDto);
        Room updatingRoom = roomRepo.findById(id).orElse(null);
        if (updatingRoom == null){
            throw new NotFoundException("Item no se encuentra - " + id);
        }
        updatingRoom.setName(updatedRoom.getName());
        updatingRoom.setBeds(updatedRoom.getBeds());
        updatingRoom.setMinPeople(updatedRoom.getMinPeople());
        updatingRoom.setMaxPeople(updatedRoom.getMaxPeople());
        updatingRoom.setDescription(updatedRoom.getDescription());
        updatingRoom.setRoomImages(updatedRoom.getRoomImages());
        updatingRoom.setRoomType(updatedRoom.getRoomType());
        roomRepo.save(updatingRoom);

    }

    @Override
    public void delete(Integer id) {
        roomRepo.deleteById(id);
    }
}
