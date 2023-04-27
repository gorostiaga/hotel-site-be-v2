package com.taras.hotelsitebev2.controllers;

import com.taras.hotelsitebev2.dtos.roomtype.RequestBodyRoomTypeDto;
import com.taras.hotelsitebev2.services.ServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RequestMapping("/roomTypes")
@CrossOrigin
@RestController
public class RoomTypeController extends ControllerInterface<RequestBodyRoomTypeDto> {

    @Autowired
    public  RoomTypeController (@Qualifier("roomTypeService") ServiceInterface serviceInterface) {
        super.serviceInterface = serviceInterface;
    }

}
