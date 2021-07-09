package com.itacademy.rating;

import com.itacademy.rating.model.*;
import com.itacademy.rating.repositories.ExerciseRepository;
import com.itacademy.rating.repositories.RatingRepository;
import com.itacademy.rating.repositories.UserRepository;
import com.itacademy.rating.repositories.VideoRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ServerWebInputException;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.StreamSupport;


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

    public void validateUser(User user)
    {
        if (userRepository.findByDni(user.getDni()) == null) throw new ServerWebInputException("DNI does not exist");
    }

    public List<Video> getVideos(String itineraryCode)
    {
        checkItineraryCode(itineraryCode);
        return videoRepository.findByItineraryCode(itineraryCode);
    }

    public List<Exercise> getExercises(String itineraryCode)
    {
        checkItineraryCode(itineraryCode);
        return exerciseRepository.findByItineraryCode(itineraryCode);
    }

    public void rateVideo(Rating rating, String itineraryCode, int videoId)
    {
        checkItineraryCode(itineraryCode);
        Optional<Video> video = videoRepository.findById(videoId);

        if (!video.isPresent()) throw new ServerWebInputException("Video with Id: " + videoId +" does not exist");

        rating.setVideo(video.get());
        ratingRepository.save(rating);
     }

    public void rateExercise(Rating rating, String itineraryCode, int exerciseId)
    {
        checkItineraryCode(itineraryCode);
        Optional<Exercise> exercise = exerciseRepository.findById(exerciseId);

        if (!exercise.isPresent()) throw new ServerWebInputException("Exercise with Id: " + exerciseId +" does not exist");
        rating.setExercise(exercise.get());
        ratingRepository.save(rating);
    }

    private void checkItineraryCode(String itineraryCode)
    {
        if (!Itinerary.ITINERARY_CODES.contains(itineraryCode)) throw new ServerWebInputException("Wrong Itinerary Code");
    }

    public List<User> getAllUsers() {
        List<User> users = new ArrayList<>();
        userRepository.findAll().iterator().forEachRemaining(users::add);
        return users;
    }
}
