package com.taras.hotelsitebev2.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "bookings")
public class Booking extends BaseEntity {

    @Column(name = "checkin_date")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate checkinDate;

    @Column(name = "checkout_date")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate checkoutDate;

    @Column(name = "number_people")
    private Integer numberPeople;

    @Column(name = "payment_date")
    private Date paymentDate;

    @Column(name = "paid_amount")
    private Double paidAmount;

    @Column(name = "created_date")
    private Date createdDate;

    @Column(name = " modified_date")
    private Date modifiedDate;

    @Enumerated(value = EnumType.STRING)
    private BookingStatus bookingStatus;

    @ManyToOne
    private Room room;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;

    @ManyToOne
    private PaymentMethod paymentMethod;

}
