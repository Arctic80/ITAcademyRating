package com.itacademy.rating.model;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Arrays;


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

    public Itinerary(String itinerary) throws ResponseStatusException
    {
        if (Arrays.asList(BE, FE, AD).contains(itinerary)) this.id = itinerary;
        else throw new ResponseStatusException(HttpStatus.NOT_ACCEPTABLE);
    }

    public String getId(){
        return id;
    }
}