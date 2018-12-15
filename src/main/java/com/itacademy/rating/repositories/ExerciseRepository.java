package com.itacademy.rating.repositories;

import com.itacademy.rating.model.Exercise;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ExerciseRepository extends CrudRepository<Exercise, Integer> {
    Iterable<Exercise> findByItinerary(String itineraryID);
}
