package com.itacademy.rating.model;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

import javax.persistence.*;
import javax.validation.constraints.NotNull;


@Entity
public class Exercise
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String name;

    @ManyToOne(fetch = FetchType.LAZY)
    private Itinerary itinerary;

    public Exercise(){}

    public Exercise(String name, @NotNull Itinerary itinerary) throws ResponseStatusException
    {
        if (name.isEmpty() || itinerary == null) throw new ResponseStatusException(HttpStatus.NOT_ACCEPTABLE);
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
