package com.taras.hotelsitebev2.converters;

import com.taras.hotelsitebev2.dtos.paymentmethod.PaymentMethodDto;
import com.taras.hotelsitebev2.model.PaymentMethod;
import lombok.Synchronized;
import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

@Component
public class PaymentMethodToPaymentMethodDto implements Converter<PaymentMethod, PaymentMethodDto> {

    @Synchronized
    @Nullable
    @Override
    public PaymentMethodDto convert(PaymentMethod source) {

        if (source == null) {
            return null;
        }

        PaymentMethodDto paymentMethodDto = new PaymentMethodDto();
        paymentMethodDto.setId(source.getId());
        paymentMethodDto.setPaymentType(source.getPaymentType());

        return paymentMethodDto;
    }
}
