package com.itacademy.rating.model;

import org.springframework.http.HttpStatus;
import org.springframework.lang.Nullable;
import org.springframework.web.server.ResponseStatusException;

import javax.persistence.*;
import javax.validation.constraints.NotNull;


@Entity
public class Rating
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @NotNull
    private int rating;

    @Nullable
    private String comment;

    @ManyToOne
    private Video video;

    @ManyToOne
    private Exercise exercise;


    public Rating() {}

    public Rating(int rating) throws ResponseStatusException
    {
        if (rating < 1 || rating > 5) throw new ResponseStatusException(HttpStatus.NOT_ACCEPTABLE);
        this.rating = rating;
    }

    @Nullable
    public String getComment() {
        return comment;
    }

    public void setComment(@Nullable String comment) {
        this.comment = comment;
    }

    public Video getVideo() {
        return video;
    }

    public void setVideo(Video video) {
        this.video = video;
    }

    public Exercise getExercise() {
        return exercise;
    }

    public void setExercise(Exercise exercise) {
        this.exercise = exercise;
    }
}