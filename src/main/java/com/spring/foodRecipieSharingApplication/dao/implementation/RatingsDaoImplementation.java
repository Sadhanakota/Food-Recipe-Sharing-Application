package com.spring.foodRecipieSharingApplication.dao.implementation;

import com.spring.foodRecipieSharingApplication.dao.RatingsDao;
import com.spring.foodRecipieSharingApplication.models.entity.Ratings;
import com.spring.foodRecipieSharingApplication.repository.RatingsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


@Repository
public class RatingsDaoImplementation implements RatingsDao {

    @Autowired
    private RatingsRepository ratingsRepository;

    @Override
    public Ratings createRatings(Ratings ratings) {
        return ratingsRepository.save(ratings);
    }
    @Override
    public Ratings findRatingsById(int id){
        Optional ratings = ratingsRepository.findById(id);
        if (ratings.isPresent()) {
            return (Ratings) ratings.get();
        }
        else {
            return null;
        }

    }
    @Override
    public Ratings updateRatings(Ratings ratings){
        return ratingsRepository.save(ratings);
    }
    @Override
    public String deleteRatings(Ratings ratings){
        ratingsRepository.delete(ratings);
        return "Ratings are deleted" ;
    }
    @Override
    public List<Ratings> getAllRatingsList(){
        return ratingsRepository.findAll();
    }

}
