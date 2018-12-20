package com.itacademy.rating.repositories;

import com.itacademy.rating.model.Exercise;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface ExerciseRepository extends CrudRepository<Exercise, Integer> {
    List<Exercise> findByItineraryCode(String itineraryID);
}
