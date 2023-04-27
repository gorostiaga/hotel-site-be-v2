package com.taras.hotelsitebev2.controllers;

import com.taras.hotelsitebev2.dtos.paymentmethod.RequestBodyPaymentMethodDto;
import com.taras.hotelsitebev2.services.ServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RequestMapping("/paymentMethods")
@RestController
public class PaymentMethodController extends ControllerInterface<RequestBodyPaymentMethodDto>{

    @Autowired
    public PaymentMethodController(@Qualifier("paymentMethodService") ServiceInterface serviceInterface) {
        super.serviceInterface = serviceInterface;
    }
}
