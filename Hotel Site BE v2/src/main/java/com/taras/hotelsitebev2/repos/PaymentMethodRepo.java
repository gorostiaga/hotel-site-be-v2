package com.taras.hotelsitebev2.repos;

import com.taras.hotelsitebev2.model.PaymentMethod;
import com.taras.hotelsitebev2.model.PaymentType;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PaymentMethodRepo extends CrudRepository<PaymentMethod, Integer> {

    Optional<PaymentMethod> getPaymentMethodByPaymentType(PaymentType paymentType);

}
