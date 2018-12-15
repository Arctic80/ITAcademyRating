package com.itacademy.rating.repositories;

import com.itacademy.rating.model.Rating;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface RatingRepository extends CrudRepository<Rating, Integer> {
}
