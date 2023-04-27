package com.taras.hotelsitebev2.repos;

import com.taras.hotelsitebev2.model.PaymentMethod;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PaymentMethodRepo extends CrudRepository<PaymentMethod, Integer> {
}
