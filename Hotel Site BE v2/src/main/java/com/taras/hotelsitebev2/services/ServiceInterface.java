package com.taras.hotelsitebev2.services;

import com.taras.hotelsitebev2.dtos.DtoInterface;

import java.util.List;
import java.util.Map;

public interface ServiceInterface {


    Map<String, List<DtoInterface>> getList();

    Map<String, DtoInterface> getById(Integer id);

    void save(DtoInterface dto);

    void delete(Integer id);

    void update(Integer id, DtoInterface dto);
}
