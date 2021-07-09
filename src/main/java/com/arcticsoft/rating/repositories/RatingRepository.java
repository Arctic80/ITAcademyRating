package com.arcticsoft.rating.repositories;

import com.arcticsoft.rating.model.Rating;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface RatingRepository extends CrudRepository<Rating, Integer> {
}
