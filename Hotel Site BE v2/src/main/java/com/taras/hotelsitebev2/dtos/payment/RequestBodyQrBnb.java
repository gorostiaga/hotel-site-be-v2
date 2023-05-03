package com.taras.hotelsitebev2.dtos.payment;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class RequestBodyQrBnb implements RequestBodyQr, Serializable {
    private String currency;
    private String gloss;
    private Double amount;
    private Boolean singleUse;
    private String expirationDate;
    private String additionalData;
    private String destinationAccountId;
}
