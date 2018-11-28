package com.itacademy.rating.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Exercise
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String name;

    public Exercise(){

    }

    public Exercise(String name){
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
