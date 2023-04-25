package com.taras.hotelsitebev2.services;

import com.taras.hotelsitebev2.dtos.DtoInterface;
import com.taras.hotelsitebev2.dtos.roomdtos.RequestBodyRoomDto;
import com.taras.hotelsitebev2.dtos.roomdtos.RoomDto;
import com.taras.hotelsitebev2.dtos.roomdtos.RoomsDto;
import com.taras.hotelsitebev2.dtos.roomdtos.RoomsItem;
import com.taras.hotelsitebev2.exceptions.NotFoundException;
import com.taras.hotelsitebev2.model.Room;
import com.taras.hotelsitebev2.model.RoomImage;
import com.taras.hotelsitebev2.repos.RoomRepo;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Service
public class RoomService implements ServiceInterface  {

    private final RoomRepo roomRepo;
    private final RoomTypeService roomTypeService;

    public RoomService(RoomRepo roomRepo, RoomTypeService roomTypeService) {
        this.roomRepo = roomRepo;
        this.roomTypeService = roomTypeService;
    }

    @Override
    public DtoInterface getList() {
        ArrayList<Room> rooms = (ArrayList<Room>) roomRepo.findAll();
        List<RoomsItem> roomsItems = new ArrayList<>();
        //get the master image
        String masterImageUrl = "";
        for(Room room : rooms ){
            Set<RoomImage> images = room.getRoomImages();
            for(RoomImage image : images){
                if(image.getDescription().equals("master")){
                    masterImageUrl = image.getFilePath();
                    break;
                }
            }
            RoomsItem roomsItem = new RoomsItem(room.getId(), room.getName(), room.getBeds(), room.getMinPeople(),
                    room.getMaxPeople(), room.getRoomType().getPricePerNight(), masterImageUrl);
            roomsItems.add(roomsItem);
        }
        return new RoomsDto(roomsItems);
    }

    @Override
    public DtoInterface getById(Integer id) {
        Room room = roomRepo.findById(id).orElse(null);
        if (room == null) {
            throw new NotFoundException("Item no se encuentra - " + id);
        }
        return new RoomDto(room);
    }

    @Override
    public void save(DtoInterface dto) {
        RequestBodyRoomDto requestBodyRoomDto = (RequestBodyRoomDto) dto;
        Room newRoom = new Room(requestBodyRoomDto.getName(), requestBodyRoomDto.getBeds(), requestBodyRoomDto.getMinPeople(),
                requestBodyRoomDto.getMaxPeople(), requestBodyRoomDto.getDescription(),
                requestBodyRoomDto.getRoomImages(), roomTypeService.getByName(requestBodyRoomDto.getRoomTypeName()) );
        roomRepo.save(newRoom);
    }

    @Override
    public void update(Integer id, DtoInterface dto) {
        RequestBodyRoomDto requestBodyRoomDto = (RequestBodyRoomDto) dto;
        Room updatedRoom = new Room(requestBodyRoomDto.getName(), requestBodyRoomDto.getBeds(), requestBodyRoomDto.getMinPeople(),
                requestBodyRoomDto.getMaxPeople(), requestBodyRoomDto.getDescription(),
                requestBodyRoomDto.getRoomImages(), roomTypeService.getByName(requestBodyRoomDto.getRoomTypeName()) );
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
