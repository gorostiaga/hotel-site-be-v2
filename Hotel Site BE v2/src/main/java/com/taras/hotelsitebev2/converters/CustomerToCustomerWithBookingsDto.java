package com.taras.hotelsitebev2.converters;

import com.taras.hotelsitebev2.dtos.customer.CustomerWithBookingsDto;
import com.taras.hotelsitebev2.model.Customer;
import lombok.Synchronized;
import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

@Component
public class CustomerToCustomerWithBookingsDto implements Converter<Customer, CustomerWithBookingsDto> {

    @Synchronized
    @Nullable
    @Override
    public CustomerWithBookingsDto convert(Customer source) {

        if (source == null) {
            return null;
        }

        final CustomerWithBookingsDto customerWithBookingsDto = new CustomerWithBookingsDto();
        customerWithBookingsDto.setIdCustomer(source.getIdCustomer());
        customerWithBookingsDto.setFirstName(source.getFirstName());
        customerWithBookingsDto.setLastName(source.getLastName());
        customerWithBookingsDto.setEmail(source.getEmail());
        customerWithBookingsDto.setPhone(source.getPhone());
        customerWithBookingsDto.setOriginCity(source.getOriginCity());
        customerWithBookingsDto.setBookings(source.getBookings());

        return customerWithBookingsDto;
    }
}
