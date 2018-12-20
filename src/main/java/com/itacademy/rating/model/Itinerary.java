package com.itacademy.rating.model;

import org.springframework.web.server.ServerWebInputException;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Arrays;
import java.util.List;


@Entity
public class Itinerary
{
    public static final String BE = "BE";
    public static final String FE = "FE";
    public static final String AD = "AD";
    public static final List<String> ITINERARY_CODES = Arrays.asList(BE, FE, AD);

    @Id
    private String code;

    public Itinerary(){}

    public Itinerary(String itineraryCode)
    {
        if (ITINERARY_CODES.contains(itineraryCode)) this.code = itineraryCode;
        else new ServerWebInputException("Wrong Itinerary code");
    }

    public String getId()
    {
        return code;
    }
}