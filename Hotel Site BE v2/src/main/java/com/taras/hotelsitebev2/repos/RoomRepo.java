package com.taras.hotelsitebev2.repos;

import com.taras.hotelsitebev2.model.Room;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoomRepo extends CrudRepository<Room, Integer> {
}
