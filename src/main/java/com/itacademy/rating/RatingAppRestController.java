package com.itacademy.rating;

import com.itacademy.rating.model.Exercise;
import com.itacademy.rating.model.Rating;
import com.itacademy.rating.model.User;
import com.itacademy.rating.model.Video;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;


@RestController
public class RatingAppRestController {

    @Autowired
    RatingAppService ratingAppService;

    @PostMapping("/users")
    public void validateUser(@RequestBody User user) {
        ratingAppService.validateUser(user);
    }

    @GetMapping("/users")
    public List<User> getUsers(){
        return ratingAppService.getAllUsers();
    }

    @GetMapping("/{itineraryCode}/videos")
    public List<Video> getVideos(@PathVariable String itineraryCode) {
        return ratingAppService.getVideos(itineraryCode);
    }

    @GetMapping("/{itineraryCode}/exercises")
    public List<Exercise> getExercises(@PathVariable String itineraryCode) {
        return ratingAppService.getExercises(itineraryCode);
    }

    @PostMapping("/{itineraryCode}/videos/{videoId}")
    public void rateVideo(@PathVariable String itineraryCode, @PathVariable int videoId, @Valid @RequestBody Rating rating) {
        ratingAppService.rateVideo(rating, itineraryCode, videoId);
    }

    @PostMapping("/{itineraryCode}/exercises/{exerciseId}")
    public void rateExercise(@PathVariable String itineraryCode, @PathVariable int exerciseId, @Valid @RequestBody Rating rating) {
        ratingAppService.rateExercise(rating, itineraryCode, exerciseId);
    }
}