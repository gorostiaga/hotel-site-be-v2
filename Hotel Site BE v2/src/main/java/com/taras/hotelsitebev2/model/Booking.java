package com.taras.hotelsitebev2.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.ManyToOne;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Booking extends BaseEntity {

    @Enumerated(value = EnumType.STRING)
    private BookingStatus bookingStatus;

    @ManyToOne
    private Room room;

    @ManyToOne
    private Customer customer;

    @ManyToOne
    private PaymentMethod paymentMethod;

}
