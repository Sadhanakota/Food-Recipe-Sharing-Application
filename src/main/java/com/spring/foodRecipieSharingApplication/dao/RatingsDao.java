package com.spring.foodRecipieSharingApplication.dao;

import com.spring.foodRecipieSharingApplication.models.entity.Ratings;

import java.util.List;

public interface RatingsDao {
    Ratings createRatings(Ratings ratings);
    Ratings findRatingsById(int id);
    Ratings updateRatings(Ratings ratings);
    String deleteRatings(Ratings ratings);
    List<Ratings> getAllRatingsList();
}
