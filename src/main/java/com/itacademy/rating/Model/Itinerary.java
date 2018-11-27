package com.itacademy.rating.Model;

import javax.persistence.*;


@Entity
public class Itinerary
{
    public static final String BE = "BE";
    public static final String FE = "FE";
    public static final String AD = "AD";

    @Id
    private String id;

    public Itinerary(){}

    public Itinerary(String itinerary){
        this.id = itinerary;
    }

    public String getId(){
        return id;
    }
}