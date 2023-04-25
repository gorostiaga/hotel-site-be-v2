package com.taras.hotelsitebev2.controllers;

import com.taras.hotelsitebev2.dtos.ApiResponse;
import com.taras.hotelsitebev2.dtos.DtoInterface;
import com.taras.hotelsitebev2.exceptions.NotFoundException;
import com.taras.hotelsitebev2.services.ServiceInterface;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

public abstract class ControllerInterface<T extends DtoInterface> {

    ServiceInterface serviceInterface;
    DtoInterface dtoInterface;

    //get list
    @GetMapping
    public ResponseEntity<DtoInterface> getList() {
        return ResponseEntity.ok(serviceInterface.getList());
    }

    //get by id
    @GetMapping(value = "/{id}")
    public ResponseEntity<DtoInterface> getById(@PathVariable("id") Integer id) {

        try {
            dtoInterface = serviceInterface.getById(id);
        } catch (NotFoundException e) {
            throw e;
        }
//        if (dtoInterface == null) {
//            throw new NotFoundException("Item no se encuentra - " + id);
//        }
        return ResponseEntity.ok(dtoInterface);
    }

    //create a new
    @PostMapping
    public ResponseEntity<DtoInterface> create(@RequestBody T dto) {
        serviceInterface.save(dto);
        return new ResponseEntity<DtoInterface>(new ApiResponse(true, "Room created"), HttpStatus.OK);
    }

    //update an existing
    @PutMapping(value = "/{id}")
    public ResponseEntity<DtoInterface> update(@PathVariable("id") Integer id, @RequestBody T dto) {
        try {
            serviceInterface.update(id, dto);
        } catch (NotFoundException e) {
            throw e;
        }
        return new ResponseEntity<DtoInterface>(new ApiResponse(true, "Room updated"), HttpStatus.OK);
    }

    //delete an existing
    @DeleteMapping(value = "/{id}")
    public ResponseEntity<DtoInterface> delete(@PathVariable("id") Integer id) {
        try {
            serviceInterface.delete(id);
        } catch (IllegalArgumentException e) {
            throw e;
        }
        return new ResponseEntity<DtoInterface>(new ApiResponse(true, "Room deleted"), HttpStatus.OK);
    }
}
