package com.taras.hotelsitebev2.controllers;

import com.taras.hotelsitebev2.dtos.roomdtos.RequestBodyRoomDto;
import com.taras.hotelsitebev2.services.ServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@CrossOrigin
@RequestMapping("/rooms")
@RestController
public class RoomController extends ControllerInterface<RequestBodyRoomDto>{

    @Autowired
    public RoomController(@Qualifier("roomService") ServiceInterface serviceInterface) {
        this.serviceInterface = serviceInterface;
    }


}
