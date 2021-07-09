package com.arcticsoft.rating.model;

import org.springframework.web.server.ServerWebInputException;

import javax.persistence.*;
import javax.validation.constraints.NotNull;


@Entity
public class Rating
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @NotNull(message = "Must set 'rating' attribute")
    private Integer rating;

    private String comment;

    @ManyToOne
    private Video video;

    @ManyToOne
    private Exercise exercise;


    public Rating(){}

    public void setRating(Integer rating)
    {
        if (rating < 1 || rating > 5) throw new ServerWebInputException("Rating must be between 1 and 5");
        this.rating = rating;
    }

    public void setComment(String comment)
    {
        this.comment = comment;
    }

    public void setVideo(Video video)
    {
        this.video = video;
    }

    public void setExercise(Exercise exercise)
    {
        this.exercise = exercise;
    }
}