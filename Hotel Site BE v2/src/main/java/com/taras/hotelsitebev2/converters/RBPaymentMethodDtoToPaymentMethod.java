package com.taras.hotelsitebev2.converters;

import com.taras.hotelsitebev2.dtos.paymentmethod.RequestBodyPaymentMethodDto;
import com.taras.hotelsitebev2.model.PaymentMethod;
import lombok.Synchronized;
import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

@Component
public class RBPaymentMethodDtoToPaymentMethod implements Converter<RequestBodyPaymentMethodDto, PaymentMethod> {

    @Synchronized
    @Nullable
    @Override
    public PaymentMethod convert(RequestBodyPaymentMethodDto source) {
        if (source == null) {
            return null;
        }
        final PaymentMethod paymentMethod = new PaymentMethod();
        paymentMethod.setPaymentType(source.getPaymentType());

        return paymentMethod;
    }
}
