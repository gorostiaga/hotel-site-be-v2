package com.taras.hotelsitebev2.controllers;

import com.taras.hotelsitebev2.dtos.payment.QrPaymentDto;
import com.taras.hotelsitebev2.model.PaymentType;
import com.taras.hotelsitebev2.services.PaymentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

//this controller does not extend ControllerInterface because
//it will call a service with a different business logic
@CrossOrigin
@RequestMapping("/payments")
@RestController
public class PaymentController {

    private final PaymentService paymentService;

    public PaymentController(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    @GetMapping
    public ResponseEntity<Map<String, QrPaymentDto>> getQr(@RequestParam("typePayment") String typePayment, @RequestParam("bookingId") Integer bookingId) {

        if (PaymentType.QR.name().equals(typePayment)) {

            return ResponseEntity.ok(paymentService.getQr(bookingId));
        }

        return null;
    }
}
