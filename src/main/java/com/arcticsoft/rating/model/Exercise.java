package com.arcticsoft.rating.model;

import org.springframework.web.server.ServerWebInputException;

import javax.persistence.*;


@Entity
public class Exercise
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String name;

    @ManyToOne
    private Itinerary itinerary;

    public Exercise(){}

    public Exercise(String name, Itinerary itinerary)
    {
        if (name.isEmpty() || itinerary == null) throw new ServerWebInputException("Empty or null parameters");
        this.name = name;
        this.itinerary = itinerary;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
