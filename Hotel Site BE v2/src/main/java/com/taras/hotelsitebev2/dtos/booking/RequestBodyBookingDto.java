package com.taras.hotelsitebev2.dtos.booking;

import com.taras.hotelsitebev2.dtos.DtoInterface;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class RequestBodyBookingDto implements DtoInterface, Serializable {
    private LocalDate checkinDate;
    private LocalDate checkoutDate;
    private Integer numberPeople;
    private Integer roomId;
    private String idCustomer;
    private String paymentTypeValue;
    private String status;
}
