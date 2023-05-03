package com.taras.hotelsitebev2.dtos.payment;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class QrApiBnbDto {

    private String id;
    private String password;
    private String tokenUrl;
    private String qrUrl;
    private String imageDirectory;

}
