package com.taras.hotelsitebev2.services;

import com.taras.hotelsitebev2.converters.RBRoomTypeDtoToRoomType;
import com.taras.hotelsitebev2.converters.RoomTypeToRoomTypeDto;
import com.taras.hotelsitebev2.dtos.DtoInterface;
import com.taras.hotelsitebev2.dtos.roomtype.RequestBodyRoomTypeDto;
import com.taras.hotelsitebev2.exceptions.NotFoundException;
import com.taras.hotelsitebev2.model.RoomType;
import com.taras.hotelsitebev2.repos.RoomTypeRepo;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class RoomTypeService implements ServiceInterface {

    private final RoomTypeRepo roomTypeRepo;
    private final RoomTypeToRoomTypeDto roomTypeDto;
    private final RBRoomTypeDtoToRoomType rbRoomTypeDtoToRoomType;

    public RoomTypeService(RoomTypeRepo roomTypeRepo, RoomTypeToRoomTypeDto roomTypeDto, RBRoomTypeDtoToRoomType rbRoomTypeDtoToRoomType) {

        this.roomTypeRepo = roomTypeRepo;
        this.roomTypeDto = roomTypeDto;
        this.rbRoomTypeDtoToRoomType = rbRoomTypeDtoToRoomType;
    }

    @Override
    public Map<String, List<DtoInterface>> getList() {

        List<DtoInterface> roomTypeItems;
        Map <String, List<DtoInterface>> response = new HashMap<>();

        roomTypeItems = StreamSupport.stream(roomTypeRepo.findAll()
                        .spliterator(),false)
                .map(roomTypeDto::convert)
                .collect(Collectors.toList());
        response.put("roomTypes", roomTypeItems);

        return response;
    }

    @Override
    public Map<String, DtoInterface> getById(Integer id) {

        RoomType roomType = roomTypeRepo.findById(id).orElse(null);
        if (roomType == null){
            throw new NotFoundException("Tipo de habitación no se encuentra - " + id);
        }
        Map<String, DtoInterface> response = new HashMap<>();
        //TODO if it is required to get all the list of rooms, it is needed to refactor this part
        response.put("roomType", roomTypeDto.convert(roomType));
        return response;
    }

    @Override
    public void save(DtoInterface dto) {
        RequestBodyRoomTypeDto requestBodyRoomTypeDto = (RequestBodyRoomTypeDto) dto;
        roomTypeRepo.save(rbRoomTypeDtoToRoomType.convert(requestBodyRoomTypeDto));
    }

    @Override
    public void delete(Integer id) {
        roomTypeRepo.deleteById(id);

    }

    @Override
    public void update(Integer id, DtoInterface dto) {
        RequestBodyRoomTypeDto requestBodyRoomTypeDto = (RequestBodyRoomTypeDto) dto;
        RoomType updatedRoomType = rbRoomTypeDtoToRoomType.convert(requestBodyRoomTypeDto);
        RoomType updatingRoomType = roomTypeRepo.findById(id).orElse(null);
        if (updatingRoomType == null){
            throw new NotFoundException("Tipo de habitación no se encuentra - " + id);
        }
        updatingRoomType.setName(updatedRoomType.getName());
        updatingRoomType.setPricePerNight((updatedRoomType.getPricePerNight()));
        roomTypeRepo.save(updatingRoomType);
    }

    public RoomType getByName(String name) {
        Set<RoomType> roomTypes = roomTypeRepo.findByName(name);
        if (!roomTypes.isEmpty()) {
            return roomTypes.iterator().next();
        }
        return null;

    }


}
