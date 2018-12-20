package com.itacademy.rating.repositories;

import com.itacademy.rating.model.Video;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface VideoRepository extends CrudRepository<Video, Integer> {
    List<Video> findByItineraryCode(String itineraryID);
}
