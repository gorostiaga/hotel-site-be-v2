package com.taras.hotelsitebev2.converters;

import com.taras.hotelsitebev2.dtos.booking.BookingDto;
import com.taras.hotelsitebev2.model.Booking;
import lombok.Synchronized;
import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

@Component
public class BookingToBookingDto implements Converter<Booking, BookingDto> {

    @Synchronized
    @Nullable
    @Override
    public BookingDto convert(Booking source) {

        if (source == null) {
            return null;
        }

        final BookingDto bookingDto = new BookingDto();
        bookingDto.setId(source.getId());
        bookingDto.setCheckinDate(source.getCheckinDate());
        bookingDto.setCheckoutDate(source.getCheckoutDate());
        bookingDto.setNumberPeople(source.getNumberPeople());
        bookingDto.setPaymentDate(source.getPaymentDate());
        bookingDto.setPaidAmount(source.getPaidAmount());
        bookingDto.setCreationDate(source.getCreationDate());
        bookingDto.setModificationDate(source.getModificationDate());
        bookingDto.setBookingStatus(source.getBookingStatus());
        bookingDto.setRoom(source.getRoom());
        bookingDto.setCustomer(source.getCustomer());
        bookingDto.setPaymentMethod(source.getPaymentMethod());

        return bookingDto;
    }
}
