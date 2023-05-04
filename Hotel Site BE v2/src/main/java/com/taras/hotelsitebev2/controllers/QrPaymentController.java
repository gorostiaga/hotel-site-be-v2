package com.taras.hotelsitebev2.controllers;

import com.taras.hotelsitebev2.dtos.payment.RequestBodyNotificationBnb;
import com.taras.hotelsitebev2.dtos.payment.ResponseNotificationBnb;
import com.taras.hotelsitebev2.observer.SubjectQr;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RequestMapping("/ReceiveNotification")
@RestController
public class QrPaymentController {

    private final SubjectQr subjectQr;

    public QrPaymentController(SubjectQr subjectQr) {
        this.subjectQr = subjectQr;
    }

    @PostMapping
    public ResponseEntity<ResponseNotificationBnb> notifyPayment (@RequestBody RequestBodyNotificationBnb requestBodyNotificationBnb) {
        subjectQr.changeState(requestBodyNotificationBnb);
        return new ResponseEntity<>(new ResponseNotificationBnb(true, "OK"), HttpStatus.OK);
    }

}
