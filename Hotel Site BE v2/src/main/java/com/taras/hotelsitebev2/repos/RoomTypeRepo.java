package com.taras.hotelsitebev2.repos;

import com.taras.hotelsitebev2.model.RoomType;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface RoomTypeRepo extends CrudRepository<RoomType, Integer> {
    Set<RoomType> findByName(String name);
}
