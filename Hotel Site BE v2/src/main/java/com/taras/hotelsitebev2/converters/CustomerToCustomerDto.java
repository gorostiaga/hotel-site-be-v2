package com.taras.hotelsitebev2.converters;

import com.taras.hotelsitebev2.dtos.customer.CustomerDto;
import com.taras.hotelsitebev2.model.Customer;
import lombok.Synchronized;
import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

@Component
public class CustomerToCustomerDto implements Converter<Customer, CustomerDto> {

    @Synchronized
    @Nullable
    @Override
    public CustomerDto convert(Customer source) {

        if (source == null) {
            return null;
        }
        CustomerDto customerDto = new CustomerDto();
        customerDto.setIdCustomer(source.getIdCustomer());
        customerDto.setFirstName(source.getFirstName());
        customerDto.setLastName(source.getLastName());
        customerDto.setEmail(source.getEmail());
        customerDto.setPhone(source.getPhone());
        customerDto.setOriginCity(source.getOriginCity());

        return customerDto;
    }
}
