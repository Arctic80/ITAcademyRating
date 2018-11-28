package com.itacademy.rating.model;

import javax.persistence.*;

@Entity
public class Itinerary
{
    public static final String BE = "BE";
    public static final String FE = "FE";
    public static final String AD = "AD";

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String id;

    public Itinerary(){}

    public Itinerary(String itinerary) throws WrongItineraryException
    {
        if (itinerary.equals(BE) || itinerary.equals(FE) || itinerary.equals(AD)) this.id = itinerary;
        else throw new WrongItineraryException();
    }

    public String getId(){
        return id;
    }
}