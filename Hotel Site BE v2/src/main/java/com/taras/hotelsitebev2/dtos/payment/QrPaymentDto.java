package com.taras.hotelsitebev2.dtos.payment;

import com.taras.hotelsitebev2.dtos.booking.BookingDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class QrPaymentDto {

    private String url;
    private BookingDto bookingDto;
}
