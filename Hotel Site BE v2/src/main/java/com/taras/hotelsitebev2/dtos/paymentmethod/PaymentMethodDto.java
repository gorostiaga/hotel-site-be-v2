package com.taras.hotelsitebev2.dtos.paymentmethod;

import com.taras.hotelsitebev2.dtos.DtoInterface;
import com.taras.hotelsitebev2.model.PaymentType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PaymentMethodDto implements DtoInterface, Serializable {

    private Integer id;
    private PaymentType paymentType;
}
