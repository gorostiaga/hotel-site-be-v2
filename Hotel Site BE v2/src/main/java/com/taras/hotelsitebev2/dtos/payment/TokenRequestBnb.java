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
public class TokenRequestBnb implements Serializable {
    private String accountId;
    private String authorizationId;
}
