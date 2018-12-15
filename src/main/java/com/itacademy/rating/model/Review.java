package com.itacademy.rating.model;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;


public class Review
{
    private final Video video;
    private final Exercise exercise;
    private final Rating rating;

    public Review(Video video, Exercise exercise, Rating rating) throws ResponseStatusException
    {
        if (rating == null) throw new ResponseStatusException(HttpStatus.NOT_ACCEPTABLE);
        if (video == null || exercise == null) throw new ResponseStatusException(HttpStatus.NOT_ACCEPTABLE);

        this.video = video;
        this.exercise = exercise;
        this.rating = rating;
    }
}