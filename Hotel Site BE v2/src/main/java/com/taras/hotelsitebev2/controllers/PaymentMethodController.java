package com.taras.hotelsitebev2.controllers;

import com.taras.hotelsitebev2.dtos.paymentmethod.RequestBodyPaymentMethodDto;
import com.taras.hotelsitebev2.services.PaymentMethodService;
import com.taras.hotelsitebev2.services.ServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin
@RequestMapping("/paymentMethods")
@RestController
public class PaymentMethodController extends ControllerInterface<RequestBodyPaymentMethodDto>{

    @Autowired
    public PaymentMethodController(@Qualifier("paymentMethodService") ServiceInterface serviceInterface) {
        super.serviceInterface = serviceInterface;
    }

    //this method is for getting the values of the enum PaymentType
    @GetMapping("/types")
    public ResponseEntity<List<String>> getPaymentTypes() {
        PaymentMethodService paymentMethodService = (PaymentMethodService) serviceInterface;
        return new ResponseEntity<>( paymentMethodService.getPaymentTypes() , HttpStatus.OK);
    }
}
