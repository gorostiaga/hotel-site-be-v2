package com.taras.hotelsitebev2.repos;

import com.taras.hotelsitebev2.model.QrPayment;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface QrPaymentRepo extends CrudRepository<QrPayment, Integer> {
    Optional<QrPayment> getQrPaymentByIdBank(Double idBank);
}
