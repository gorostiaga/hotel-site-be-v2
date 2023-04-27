package com.taras.hotelsitebev2.services;

import com.taras.hotelsitebev2.converters.RBRoomDtoToRoom;
import com.taras.hotelsitebev2.converters.RoomToRoomDto;
import com.taras.hotelsitebev2.converters.RoomToRoomWithImagesDto;
import com.taras.hotelsitebev2.dtos.DtoInterface;
import com.taras.hotelsitebev2.dtos.roomdtos.RequestBodyRoomDto;
import com.taras.hotelsitebev2.dtos.roomdtos.RoomDto;
import com.taras.hotelsitebev2.dtos.roomdtos.RoomWithImagesDto;
import com.taras.hotelsitebev2.model.Room;
import com.taras.hotelsitebev2.repos.RoomRepo;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class RoomServiceTest {

    @Mock
    RoomRepo roomRepo;
    @Mock
    RoomToRoomDto roomToRoomDto;
    @Mock
    RoomToRoomWithImagesDto roomWithImagesDto;
    @Mock
    RBRoomDtoToRoom rbRoomDtoToRoom;
    @InjectMocks
    RoomService roomService;

    Room room1;

    @BeforeEach
    void setUp() {
        room1 = new Room();
        room1.setId(1);
        room1.setName("cabana 1");
        room1.setDescription("Comoda deli");
        room1.setBeds(3);
        room1.setRoomImages(new HashSet<>());
    }

    @Test
    void getList() {

        //given

        // mock RoomRepo to return some sample data
        List<Room> rooms = new ArrayList<>();
        Room room2 = new Room();
        room2.setId(2);
        room2.setName("cabana 2");
        room2.setBeds(2);
        rooms.add(room1);
        rooms.add(room2);
        when(roomRepo.findAll()).thenReturn(rooms);

        // mock RoomToRoomDto to return a converted DTO
        RoomDto roomDto1 = new RoomDto();
        RoomDto roomDto2 = new RoomDto();
        roomDto1.setId(1);
        roomDto1.setName("cabana 1");
        roomDto1.setBeds(3);
        roomDto2.setId(2);
        roomDto2.setName("cabana 2");
        roomDto2.setBeds(2);
        when(roomToRoomDto.convert(room1)).thenReturn(roomDto1);
        when(roomToRoomDto.convert(room2)).thenReturn(roomDto2);


        Map<String, List<DtoInterface>> expectedResponse = new HashMap<>();
        List<DtoInterface> roomsItems = new ArrayList<>();
        roomsItems.add(roomDto1);
        roomsItems.add(roomDto2);
        expectedResponse.put("rooms", roomsItems);

        //when
        Map<String, List<DtoInterface>> actualResponse = roomService.getList();

        //then
        assertEquals(expectedResponse, actualResponse);
        verify(roomRepo, times(1)).findAll();
    }

    @Test
    void getById() {
        //given
        Optional<Room> optionalRoom = Optional.of(room1);
        when(roomRepo.findById(1)).thenReturn(optionalRoom);

        RoomWithImagesDto roomWithImagesDto1 = new RoomWithImagesDto();
        roomWithImagesDto1.setId(1);
        roomWithImagesDto1.setName("cabana 1");
        roomWithImagesDto1.setDescription("Comoda deli");
        roomWithImagesDto1.setBeds(3);
        roomWithImagesDto1.setRoomImages(new HashSet<>());
        when(roomWithImagesDto.convert(room1)).thenReturn(roomWithImagesDto1);

        Map<String, DtoInterface> expectedResponse = new HashMap<>();
        expectedResponse.put("room", roomWithImagesDto1);

        //when
        Map<String, DtoInterface> actualResponse = roomService.getById(1);

        //then
        assertEquals(expectedResponse, actualResponse);
        assertNotNull(actualResponse);
        verify(roomRepo, times(1)).findById(anyInt());
    }

    @Test
    void save() {
        //given
        Room roomToSave = new Room();
        roomToSave.setId(1);
        roomToSave.setName("cabana 1");
        roomToSave.setDescription("Comoda deli");
        roomToSave.setBeds(3);
        roomToSave.setRoomImages(new HashSet<>());

        RequestBodyRoomDto requestBodyRoomDto = new RequestBodyRoomDto();
        requestBodyRoomDto.setName("cabana 1");
        requestBodyRoomDto.setDescription("Comoda deli");
        requestBodyRoomDto.setBeds(3);
        requestBodyRoomDto.setRoomImages(new HashSet<>());
        when(rbRoomDtoToRoom.convert(requestBodyRoomDto)).thenReturn(room1);

        when(roomRepo.save(any())).thenReturn(room1);

        //when
        roomService.save(requestBodyRoomDto);

        //then
        verify(roomRepo, times(1)).save(any());
    }

    @Test
    void update() {
    }

    @Test
    void delete() {
    }
}