package com.taras.hotelsitebev2.dtos;

//Use this class whenever you need to send a customized
//message to the FE via any controller

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ApiResponse implements DtoInterface {

    private boolean success;
    private String message;
    private long timeStamp;

    public ApiResponse(boolean success, String message) {
        this.success = success;
        this.message = message;
        this.timeStamp = System.currentTimeMillis();
    }
}
