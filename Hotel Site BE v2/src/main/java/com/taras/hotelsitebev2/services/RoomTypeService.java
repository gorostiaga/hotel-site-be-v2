package com.taras.hotelsitebev2.services;

import com.taras.hotelsitebev2.dtos.DtoInterface;
import com.taras.hotelsitebev2.model.RoomType;
import com.taras.hotelsitebev2.repos.RoomTypeRepo;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Set;

@Service
public class RoomTypeService implements ServiceInterface {

    private final RoomTypeRepo roomTypeRepo;

    public RoomTypeService(RoomTypeRepo roomTypeRepo) {
        this.roomTypeRepo = roomTypeRepo;
    }

    @Override
    public Map<String, List<DtoInterface>> getList() {
        return null;
    }

    @Override
    public Map<String, DtoInterface> getById(Integer id) {
        return null;
    }

    @Override
    public void save(DtoInterface dto) {

    }

    @Override
    public void delete(Integer id) {

    }

    @Override
    public void update(Integer id, DtoInterface dto) {

    }

    public RoomType getByName(String name) {
        Set<RoomType> roomTypes = roomTypeRepo.findByName(name);
        if (!roomTypes.isEmpty()) {
            return roomTypes.iterator().next();
        }
        return null;

    }


}
