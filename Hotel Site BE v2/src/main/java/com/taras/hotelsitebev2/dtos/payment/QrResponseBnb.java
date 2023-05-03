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
public class QrResponseBnb implements QrResponse, Serializable {
    private String id;
    private String qr;

}
