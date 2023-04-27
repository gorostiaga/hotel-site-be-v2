package com.taras.hotelsitebev2.controllers;

import com.taras.hotelsitebev2.dtos.ApiResponse;
import com.taras.hotelsitebev2.dtos.DtoInterface;
import com.taras.hotelsitebev2.exceptions.NotFoundException;
import com.taras.hotelsitebev2.services.ServiceInterface;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

public abstract class ControllerInterface<T extends DtoInterface> {

    ServiceInterface serviceInterface;
    DtoInterface dtoInterface;

    //get list
    @GetMapping
    public ResponseEntity<Map<String, List<DtoInterface>>> getList() {

        return ResponseEntity.ok(serviceInterface.getList());
    }

    //get by id
    @GetMapping(value = "/{id}")
    public ResponseEntity<Map<String, DtoInterface>> getById(@PathVariable("id") Integer id) {

        try {
            return ResponseEntity.ok(serviceInterface.getById(id));
        } catch (NotFoundException e) {
            throw e;
        }
//        if (dtoInterface == null) {
//            throw new NotFoundException("Item no se encuentra - " + id);
//        }

    }

    //create a new
    @PostMapping
    public ResponseEntity<DtoInterface> create(@RequestBody T dto) {
        serviceInterface.save(dto);
        return new ResponseEntity<DtoInterface>(new ApiResponse(true, "Entity created"), HttpStatus.OK);
    }

    //update an existing
    @PutMapping(value = "/{id}")
    public ResponseEntity<DtoInterface> update(@PathVariable("id") Integer id, @RequestBody T dto) {
        try {
            serviceInterface.update(id, dto);
        } catch (NotFoundException e) {
            //TODO fix this warming
            throw e;
        }
        return new ResponseEntity<DtoInterface>(new ApiResponse(true, "Entity updated"), HttpStatus.OK);
    }

    //delete an existing
    @DeleteMapping(value = "/{id}")
    public ResponseEntity<DtoInterface> delete(@PathVariable("id") Integer id) {
        try {
            serviceInterface.delete(id);
        } catch (IllegalArgumentException e) {
            //TODO fix this warming
            throw e;
        }
        return new ResponseEntity<DtoInterface>(new ApiResponse(true, "Entity deleted"), HttpStatus.OK);
    }
}
