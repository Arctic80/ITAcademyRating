package com.itacademy.rating;

import com.itacademy.rating.model.Exercise;
import com.itacademy.rating.model.Rating;
import com.itacademy.rating.model.User;
import com.itacademy.rating.model.Video;
import com.itacademy.rating.repositories.ExerciseRepository;
import com.itacademy.rating.repositories.RatingRepository;
import com.itacademy.rating.repositories.UserRepository;
import com.itacademy.rating.repositories.VideoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;


@Service
public class RatingAppService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    VideoRepository videoRepository;

    @Autowired
    ExerciseRepository exerciseRepository;

    @Autowired
    RatingRepository ratingRepository;


    public void validateUser(User user) throws ResponseStatusException {
        if (!userRepository.findByDni(user.getDni()).iterator().hasNext()) throw new ResponseStatusException(HttpStatus.NOT_ACCEPTABLE);
    }

    public Iterable<Video> getVideos(String itineraryID) {
        return videoRepository.findByItinerary(itineraryID);
    }

    public Iterable<Exercise> getExercises(String itineraryID) {
        return exerciseRepository.findByItinerary(itineraryID);
    }

    public void rateVideo(Rating rating, int videoId) {
        Optional<Video> video = videoRepository.findById(videoId);
        rating.setVideo(video.get());
        ratingRepository.save(rating);
    }

    public void rateExercise(Rating rating, int exerciseId) {
        Optional<Exercise> exercise = exerciseRepository.findById(exerciseId);
        rating.setExercise(exercise.get());
        ratingRepository.save(rating);
    }
}