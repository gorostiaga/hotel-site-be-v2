package com.taras.hotelsitebev2.model;

import java.io.Serializable;

//TODO set the lombok annotations and the Entity and Table Annotations
public class Bed implements Serializable {
    //TODO implement the hibernate annotations
    private Integer id;

    private String name;

    private Integer numberOfPeople;

    //TODO set the relationship with Room if needed
}
