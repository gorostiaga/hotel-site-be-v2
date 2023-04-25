package com.taras.hotelsitebev2.services;

import com.taras.hotelsitebev2.dtos.DtoInterface;

public interface ServiceInterface {


    DtoInterface getList();

    DtoInterface getById(Integer id);

    void save(DtoInterface dto);

    void delete(Integer id);

    void update(Integer id, DtoInterface dto);
}
