package com.taras.hotelsitebev2.dtos.payment;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ResponseNotificationBnb {
    private boolean success;
    private String message;
}
