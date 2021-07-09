package com.arcticsoft.rating.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

import com.arcticsoft.rating.model.Exercise;


@Repository
public interface ExerciseRepository extends CrudRepository<Exercise, Integer> {
    List<Exercise> findByItineraryCode(String itineraryID);
}
