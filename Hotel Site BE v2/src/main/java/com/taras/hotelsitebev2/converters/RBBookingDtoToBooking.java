package com.taras.hotelsitebev2.converters;

import com.taras.hotelsitebev2.dtos.booking.RequestBodyBookingDto;
import com.taras.hotelsitebev2.model.Booking;
import com.taras.hotelsitebev2.model.PaymentType;
import com.taras.hotelsitebev2.services.CustomerService;
import com.taras.hotelsitebev2.services.PaymentMethodService;
import com.taras.hotelsitebev2.services.RoomService;
import lombok.Synchronized;
import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

@Component
public class RBBookingDtoToBooking implements Converter<RequestBodyBookingDto, Booking> {

    private final RoomService roomService;
    private final CustomerService customerService;
    private final PaymentMethodService paymentMethodService;

    public RBBookingDtoToBooking(RoomService roomService, CustomerService customerService, PaymentMethodService paymentMethodService) {
        this.roomService = roomService;
        this.customerService = customerService;
        this.paymentMethodService = paymentMethodService;
    }

    @Synchronized
    @Nullable
    @Override
    public Booking convert(RequestBodyBookingDto source) {
        if (source == null) {
            return null;
        }

        final Booking booking = new Booking();
        booking.setCheckinDate(source.getCheckinDate());
        booking.setCheckoutDate(source.getCheckoutDate());
        booking.setNumberPeople(source.getNumberPeople());


        booking.setRoom(roomService.getRoomById(source.getRoomId()));
        booking.setCustomer(customerService.getCustomerById(source.getIdCustomer()));
        booking.setPaymentMethod(paymentMethodService.getPaymentMethodByType(PaymentType.valueOf(source.getPaymentTypeValue())));

        return booking;
    }
}
