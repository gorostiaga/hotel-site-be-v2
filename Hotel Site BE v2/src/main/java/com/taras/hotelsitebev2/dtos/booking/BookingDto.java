package com.taras.hotelsitebev2.dtos.booking;

import com.taras.hotelsitebev2.dtos.DtoInterface;
import com.taras.hotelsitebev2.model.BookingStatus;
import com.taras.hotelsitebev2.model.Customer;
import com.taras.hotelsitebev2.model.PaymentMethod;
import com.taras.hotelsitebev2.model.Room;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;

//This dto will have all the properties from the model class including the ID
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class BookingDto implements DtoInterface, Serializable {

    private Integer id;
    private LocalDate checkinDate;
    private LocalDate checkoutDate;
    private Integer numberPeople;
    private Date paymentDate;
    private Double paidAmount;
    private Date creationDate;
    private Date modificationDate;
    private BookingStatus bookingStatus;
    private Room room;
    private Customer customer;
    private PaymentMethod paymentMethod;
}
