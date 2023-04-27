package com.taras.hotelsitebev2.controllers;

import com.taras.hotelsitebev2.dtos.customer.CustomerDto;
import com.taras.hotelsitebev2.services.ServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RequestMapping("/customers")
@RestController
public class CustomerController extends ControllerInterface<CustomerDto> {

    @Autowired
    public CustomerController(@Qualifier("customerService") ServiceInterface serviceInterface) {
        super.serviceInterface = serviceInterface;
    }
}
