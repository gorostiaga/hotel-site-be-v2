package com.taras.hotelsitebev2.services;

import com.taras.hotelsitebev2.converters.BookingToBookingDto;
import com.taras.hotelsitebev2.dtos.booking.BookingDto;
import com.taras.hotelsitebev2.dtos.payment.QrPaymentDto;
import com.taras.hotelsitebev2.model.Booking;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class PaymentService {

    final private BookingService bookingService;
    final private BookingToBookingDto bookingToBookingDto;
    final private QrServiceInterface qrServiceInterface;

    public PaymentService(BookingService bookingService, BookingToBookingDto bookingToBookingDto,
                          @Qualifier("qrServiceBnb") QrServiceInterface qrServiceInterface) {
        this.bookingService = bookingService;
        this.bookingToBookingDto = bookingToBookingDto;
        this.qrServiceInterface = qrServiceInterface;
    }

    public Map<String, QrPaymentDto> getQr(Integer bookingId) {
        Map<String, QrPaymentDto> response = new HashMap<>();
        Booking booking = bookingService.getBookingById(bookingId);
        BookingDto bookingDto = bookingToBookingDto.convert(booking);
        String qrUrl = qrServiceInterface.getQrUrl(bookingDto);

        QrPaymentDto qrPaymentDto = new QrPaymentDto();
        qrPaymentDto.setUrl(qrUrl);
        qrPaymentDto.setBookingDto(bookingDto);
        response.put("qr", qrPaymentDto);
        return response;

    }
}
