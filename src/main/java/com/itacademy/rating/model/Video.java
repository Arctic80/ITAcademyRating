package com.itacademy.rating.model;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;


@Entity
public class Video
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @NotNull @NotEmpty
    private String name;

    @ManyToOne(fetch = FetchType.LAZY)
    private Itinerary itinerary;

    public Video() {}

    public Video(String name, Itinerary itinerary) throws ResponseStatusException
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

    // Not "getItinerary" to exclude field from JSON
    public Itinerary getVideoItinerary() {
        return itinerary;
    }
}