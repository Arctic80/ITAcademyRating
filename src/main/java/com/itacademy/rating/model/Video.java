package com.itacademy.rating.model;

import org.springframework.web.server.ServerWebInputException;

import javax.persistence.*;


@Entity
public class Video
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String name;

    @ManyToOne
    private Itinerary itinerary;

    public Video() {}

    public Video(String name, Itinerary itinerary)
    {
        if (name.isEmpty() || itinerary == null) throw new ServerWebInputException("Not empty/null Name and Itinerary are required");
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