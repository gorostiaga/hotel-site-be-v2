package com.taras.hotelsitebev2.model;

import java.io.Serializable;

//TODO set the lombok annotations and the Entity and Table Annotations
public class Room implements Serializable {
//TODO implement the hibernate annotations
    private Integer id;

    private String name;

    private  Integer minPeople;

    private  Integer maxPeople;

    private  String description;


    //TODO Set the relationship with RoomType, Bed and Price



}
