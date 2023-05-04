package com.taras.hotelsitebev2.services;

import com.taras.hotelsitebev2.converters.BookingToBookingDto;
import com.taras.hotelsitebev2.dtos.booking.BookingDto;
import com.taras.hotelsitebev2.dtos.booking.RequestBodyBookingDto;
import com.taras.hotelsitebev2.dtos.payment.QrPaymentDto;
import com.taras.hotelsitebev2.dtos.payment.RequestBodyNotificationBnb;
import com.taras.hotelsitebev2.model.Booking;
import com.taras.hotelsitebev2.model.QrPayment;
import com.taras.hotelsitebev2.model.QrStatus;
import com.taras.hotelsitebev2.observer.ObserverInterface;
import com.taras.hotelsitebev2.observer.SubjectInterface;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Service
public class PaymentService implements ObserverInterface {

    final private BookingService bookingService;
    final private BookingToBookingDto bookingToBookingDto;
    final private QrServiceInterface qrServiceInterface;
    final private SubjectInterface subjectInterface;
    final private QrPaymentService qrPaymentService;

    private RequestBodyNotificationBnb requestBodyNotificationBnb;

    public PaymentService(BookingService bookingService, BookingToBookingDto bookingToBookingDto,
                          @Qualifier("qrServiceBnb") QrServiceInterface qrServiceInterface, SubjectInterface subjectInterface,
                          QrPaymentService qrPaymentService) {
        this.bookingService = bookingService;
        this.bookingToBookingDto = bookingToBookingDto;
        this.qrServiceInterface = qrServiceInterface;
        this.subjectInterface = subjectInterface;
        this.qrPaymentService = qrPaymentService;

        this.subjectInterface.registerObserver(this);
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

    @Override
    public void update(RequestBodyNotificationBnb requestBodyNotificationBnb) {
        this.requestBodyNotificationBnb = requestBodyNotificationBnb;

        //TODO refactor this piece to add more payment methods
        QrPayment qrPayment = qrPaymentService.getByIdBank(Double.valueOf(requestBodyNotificationBnb.getQrId()));
        qrPayment.setGloss(requestBodyNotificationBnb.getGloss());
        qrPayment.setSourceBankId(requestBodyNotificationBnb.getSourceBankId());
        qrPayment.setOriginName(requestBodyNotificationBnb.getOriginName());
        qrPayment.setVoucherId(requestBodyNotificationBnb.getVoucherId());
        //turn string into Date
        qrPayment.setTransactionDateTime(convertToDate(requestBodyNotificationBnb.getTransactionDateTime()));

        Integer bookingId = qrPayment.getBooking().getId();
        RequestBodyBookingDto requestBodyBookingDto = new RequestBodyBookingDto();
        requestBodyBookingDto.setStatus("booked");
        bookingService.update(bookingId, requestBodyBookingDto);

        qrPaymentService.update(qrPayment, QrStatus.PAID);

    }

    private Date convertToDate(String date)  {
        try {
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
            return dateFormat.parse(date);
        } catch (ParseException e) {
            throw new RuntimeException(e.getMessage());
        }
    }
}
