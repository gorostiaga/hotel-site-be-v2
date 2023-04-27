package com.taras.hotelsitebev2.repos;

import com.taras.hotelsitebev2.model.Booking;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookingRepo extends CrudRepository<Booking, Integer> {
}
