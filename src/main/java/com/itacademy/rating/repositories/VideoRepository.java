package com.itacademy.rating.repositories;

import com.itacademy.rating.model.Video;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface VideoRepository extends CrudRepository<Video, Integer> {
    Iterable<Video> findByItinerary(String itineraryID);
}
