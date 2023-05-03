package com.taras.hotelsitebev2.services;

import com.taras.hotelsitebev2.dtos.booking.BookingDto;

public interface QrServiceInterface {


    String getQrUrl (BookingDto bookingDto);


}
