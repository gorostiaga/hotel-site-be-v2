package com.taras.hotelsitebev2.dtos.customer;

import com.taras.hotelsitebev2.dtos.DtoInterface;
import com.taras.hotelsitebev2.model.Booking;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CustomerWithBookingsDto implements DtoInterface, Serializable {

    private String idCustomer;
    private String firstName;
    private String lastName;
    private String email;
    private Integer phone;
    private String originCity;
    private Set<Booking> bookings = new HashSet<>();
}
