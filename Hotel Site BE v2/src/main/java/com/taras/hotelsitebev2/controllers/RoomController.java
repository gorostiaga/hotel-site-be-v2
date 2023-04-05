package com.taras.hotelsitebev2.controllers;

import com.taras.hotelsitebev2.services.RoomService;

//TODO set the required annotation for mapping and controller
public class RoomController {

    private final RoomService roomService;
    public RoomController(RoomService roomService) {
        this.roomService = roomService;
    }


}
