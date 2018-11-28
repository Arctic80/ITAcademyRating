package com.itacademy.rating.model;

public class Review
{
    Video video;
    Exercise exercise;
    Rating rating;

    public Review(Video video, Exercise exercise, Rating rating) throws InvalidReviewParams
    {
        // Revisar
        if ((video == null || exercise == null) || rating == null) throw new InvalidReviewParams();

        this.video = video;
        this.exercise = exercise;
        this.rating = rating;
    }
}