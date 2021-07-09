package com.arcticsoft.rating.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

import com.arcticsoft.rating.model.Video;


@Repository
public interface VideoRepository extends CrudRepository<Video, Integer> {
    List<Video> findByItineraryCode(String itineraryID);
}
