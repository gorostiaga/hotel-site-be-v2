package com.taras.hotelsitebev2.services;

import com.taras.hotelsitebev2.converters.BookingToBookingDto;
import com.taras.hotelsitebev2.converters.RBBookingDtoToBooking;
import com.taras.hotelsitebev2.dtos.DtoInterface;
import com.taras.hotelsitebev2.dtos.booking.RequestBodyBookingDto;
import com.taras.hotelsitebev2.exceptions.NotFoundException;
import com.taras.hotelsitebev2.model.Booking;
import com.taras.hotelsitebev2.model.BookingStatus;
import com.taras.hotelsitebev2.repos.BookingRepo;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class BookingService implements ServiceInterface {

    private final BookingRepo bookingRepo;
    private final BookingToBookingDto bookingToBookingDto;
    private final RBBookingDtoToBooking rbBookingDtoToBooking;

    public BookingService(BookingRepo bookingRepo, BookingToBookingDto bookingToBookingDto, RBBookingDtoToBooking rbBookingDtoToBooking) {
        this.bookingRepo = bookingRepo;
        this.bookingToBookingDto = bookingToBookingDto;
        this.rbBookingDtoToBooking = rbBookingDtoToBooking;
    }

    @Override
    public Map<String, List<DtoInterface>> getList() {
        //TODO implement this method when is required, at this moment I don't think is needed.
        return null;
    }

    @Override
    public Map<String, DtoInterface> getById(Integer id) {
        Booking booking = bookingRepo.findById(id).orElseThrow(() -> new NotFoundException("Reserva no encontrada - " + id));
        Map<String, DtoInterface> response = new HashMap<>();
        response.put("booking", bookingToBookingDto.convert(booking));
        return response;
    }

    @Override
    public void save(DtoInterface dto) {
        RequestBodyBookingDto requestBodyBookingDto = (RequestBodyBookingDto) dto;
        Booking savingBooking = rbBookingDtoToBooking.convert(requestBodyBookingDto);
        savingBooking.setBookingStatus(BookingStatus.PRE_BOOKED);
        savingBooking.setCreationDate(new Date());
        //calculation of the total price to be paid
        Double pricePerNight = savingBooking.getRoom().getRoomType().getPricePerNight();
        Long numberOfNights = getNumberOfNights(savingBooking.getCheckinDate(), savingBooking.getCheckoutDate());
        Double paidAmount = savingBooking.getNumberPeople() * numberOfNights * pricePerNight;
        savingBooking.setPaidAmount(paidAmount);
        bookingRepo.save(savingBooking);
    }

    @Override
    public void delete(Integer id) {
        bookingRepo.deleteById(id);
    }

    @Override
    public void update(Integer id, DtoInterface dto) {
        RequestBodyBookingDto requestBodyBookingDto = (RequestBodyBookingDto) dto;
        if(requestBodyBookingDto.getStatus().equals("cancelled") ) {
            Booking updatingBooking = bookingRepo.findById(id).orElseThrow(() -> new NotFoundException("Reserva no encontrada - " + id));
            updatingBooking.setBookingStatus(BookingStatus.CANCELLED);
            updatingBooking.setModificationDate(new Date());
            bookingRepo.save(updatingBooking);
        }
    }

    private Long getNumberOfNights(LocalDate checkinDate, LocalDate checkoutDate) {
        return ChronoUnit.DAYS.between(checkinDate, checkoutDate);
    }

    public Booking getBookingById (Integer bookingId) {
        return  bookingRepo.findById(bookingId).orElseThrow(() -> new NotFoundException("Reserva no encontrada - " + bookingId));
    }
}
