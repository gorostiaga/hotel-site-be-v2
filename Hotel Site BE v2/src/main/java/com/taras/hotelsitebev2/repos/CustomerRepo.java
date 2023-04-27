package com.taras.hotelsitebev2.repos;

import com.taras.hotelsitebev2.model.Customer;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepo extends CrudRepository<Customer, String> {
}
