package com.taras.hotelsitebev2.controllers;

import com.taras.hotelsitebev2.dtos.booking.RequestBodyBookingDto;
import com.taras.hotelsitebev2.services.ServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RequestMapping("/bookings")
@RestController
public class BookingController extends ControllerInterface<RequestBodyBookingDto> {

    @Autowired
    public BookingController(@Qualifier("bookingService") ServiceInterface serviceInterface) {
        super.serviceInterface = serviceInterface;
    }
}
