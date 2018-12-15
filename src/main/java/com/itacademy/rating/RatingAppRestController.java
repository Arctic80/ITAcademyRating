package com.itacademy.rating;

import com.itacademy.rating.model.Exercise;
import com.itacademy.rating.model.Rating;
import com.itacademy.rating.model.User;
import com.itacademy.rating.model.Video;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;


@RestController
public class RatingAppRestController {

    @Autowired
    RatingAppService ratingAppService;

    @PostMapping("/users")
    public void validateUser(@RequestBody User user) throws ResponseStatusException {
        ratingAppService.validateUser(user);
    }

    @GetMapping("/{itineraryId}/videos")
    public Iterable<Video> getVideos(@PathVariable String itineraryId) {
        return ratingAppService.getVideos(itineraryId);
    }

    @GetMapping("/{itineraryId}/exercises")
    public Iterable<Exercise> getExercises(@PathVariable String itineraryId) {
        return ratingAppService.getExercises(itineraryId);
    }

    @PostMapping("/{itineraryId}/videos/{videoId}")
    public void rateVideo(@PathVariable String itineraryId, @PathVariable int videoId,@Validated @RequestBody Rating rating) throws ResponseStatusException {
        ratingAppService.rateVideo(rating, videoId);
    }

    @PostMapping("/{itineraryId}/exercises/{exerciseId}")
    public void rateExercise(@PathVariable String itineraryId, @PathVariable int exerciseId, @Validated @RequestBody Rating rating) throws ResponseStatusException {
        ratingAppService.rateExercise(rating, exerciseId);
    }
}