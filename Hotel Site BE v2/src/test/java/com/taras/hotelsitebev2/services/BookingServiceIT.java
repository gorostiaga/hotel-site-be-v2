package com.taras.hotelsitebev2.services;

import com.taras.hotelsitebev2.converters.BookingToBookingDto;
import com.taras.hotelsitebev2.converters.RBBookingDtoToBooking;
import com.taras.hotelsitebev2.dtos.booking.RequestBodyBookingDto;
import com.taras.hotelsitebev2.model.Booking;
import com.taras.hotelsitebev2.repos.BookingRepo;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@DataJpaTest
class BookingServiceIT {

    @Autowired
    BookingService bookingService;
    @Autowired
    BookingRepo bookingRepo;
    @Autowired
    BookingToBookingDto bookingToBookingDto;
    @Autowired
    RBBookingDtoToBooking rbBookingDtoToBooking;

    @BeforeEach
    void setUp() {
    }

    @Test
    @Transactional
    public void testSaveBooking() throws Exception {

        //given
        RequestBodyBookingDto requestBodyBookingDto = new RequestBodyBookingDto();
        requestBodyBookingDto.setCheckinDate(LocalDate.now());
        requestBodyBookingDto.setCheckoutDate(LocalDate.now().plusDays(3));
        requestBodyBookingDto.setNumberPeople(2);
        requestBodyBookingDto.setPaidAmount(100.0);
        requestBodyBookingDto.setRoomId(1);
        requestBodyBookingDto.setIdCustomer("customer-id");
        requestBodyBookingDto.setPaymentTypeValue("QR");

        //when
        bookingService.save(requestBodyBookingDto);

        //then
//        Iterable<Booking> iterableBookings = bookingRepo.findAll();
        List<Booking> bookings = (List<Booking>) bookingRepo.findAll();
//        List<Booking> bookings = new ArrayList<>();
//        iterableBookings.forEach(bookings::add);
        assertEquals(1, bookings.size());
        Booking savedBooking = bookings.get(0);
        assertEquals(requestBodyBookingDto.getCheckinDate(), savedBooking.getCheckinDate());
        assertEquals(requestBodyBookingDto.getCheckoutDate(), savedBooking.getCheckoutDate());
        assertEquals(requestBodyBookingDto.getNumberPeople(), savedBooking.getNumberPeople());
        assertEquals(requestBodyBookingDto.getPaidAmount(), savedBooking.getPaidAmount(), 0.001);
        assertEquals(requestBodyBookingDto.getRoomId(), savedBooking.getRoom().getId());
        assertEquals(requestBodyBookingDto.getIdCustomer(), savedBooking.getCustomer().getIdCustomer());
        assertEquals(requestBodyBookingDto.getPaymentTypeValue(), savedBooking.getPaymentMethod().getPaymentType().name());

    }
}