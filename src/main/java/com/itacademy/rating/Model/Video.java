package com.itacademy.rating.Model;

import javax.persistence.*;

@Entity
public class Video
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String name;

    @ManyToOne(fetch = FetchType.LAZY)
    private Itinerary itinerary;

    public Video() {
    }

    public Video(String name, Itinerary itinerary) {
        this.name = name;
        this.itinerary = itinerary;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Itinerary getItinerary() {
        return itinerary;
    }
}