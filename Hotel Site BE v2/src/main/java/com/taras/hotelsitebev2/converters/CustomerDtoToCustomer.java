package com.taras.hotelsitebev2.converters;

import com.taras.hotelsitebev2.dtos.customer.CustomerDto;
import com.taras.hotelsitebev2.model.Customer;
import lombok.Synchronized;
import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

@Component
public class CustomerDtoToCustomer implements Converter<CustomerDto, Customer> {

    @Synchronized
    @Nullable
    @Override
    public Customer convert(CustomerDto source) {

        if (source == null) {
            return null;
        }

        final Customer customer = new Customer();
        customer.setIdCustomer(source.getIdCustomer());
        customer.setFirstName(source.getFirstName());
        customer.setLastName(source.getLastName());
        customer.setEmail(source.getEmail());
        customer.setPhone(source.getPhone());
        customer.setOriginCity(source.getOriginCity());

        return customer;
    }
}
