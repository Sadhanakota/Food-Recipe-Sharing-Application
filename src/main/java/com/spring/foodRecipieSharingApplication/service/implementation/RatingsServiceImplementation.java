package com.spring.foodRecipieSharingApplication.service.implementation;

import com.spring.foodRecipieSharingApplication.dao.RatingsDao;
import com.spring.foodRecipieSharingApplication.exception.DataNotFoundException;
import com.spring.foodRecipieSharingApplication.models.dto.RatingsDto;
import com.spring.foodRecipieSharingApplication.models.dto.ResponseStructure;
import com.spring.foodRecipieSharingApplication.models.entity.Ratings;
import com.spring.foodRecipieSharingApplication.service.RatingsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RatingsServiceImplementation implements RatingsService{


    @Autowired
   private RatingsDao ratingsDao;
    @Override
    public ResponseEntity<ResponseStructure<Ratings>> createRatings(RatingsDto ratingsDto) {
        Ratings ratings=new Ratings();

        ratings.setScore(ratingsDto.getScore());
        ratings.setComment(ratingsDto.getComment());

        ResponseStructure<Ratings> responseStructure=new ResponseStructure<>();
        responseStructure.setData(ratingsDao.createRatings(ratings));
        responseStructure.setMessage("Ratings Created Successfully");
        responseStructure.setStatusCode(HttpStatus.CREATED.value());
        return new ResponseEntity<>(responseStructure,HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<ResponseStructure<Ratings>> findRatingsById(int id) {
        Ratings ratings=ratingsDao.findRatingsById(id);
        if(ratings!=null)
        {
            ResponseStructure<Ratings> responseStructure=new ResponseStructure<>();
            responseStructure.setStatusCode(HttpStatus.FOUND.value());
            responseStructure.setMessage("Rating is fetched successfully");
            responseStructure.setData(ratings);
            return new ResponseEntity<>(responseStructure,HttpStatus.FOUND);
        }
        else{
            throw new DataNotFoundException("Ratings is not found");
        }
    }

    @Override
    public ResponseEntity<ResponseStructure<Ratings>> updateRatings(int id,RatingsDto ratingsDto) {

        Ratings ratings=ratingsDao.findRatingsById(id);
        if(ratings!=null)
        {
            int score= ratingsDto.getScore();
            if(score!=0)
            {
                ratings.setScore(score);
            }
            String comment= ratingsDto.getComment();
            if(comment!=null)
            {
                ratings.setComment(comment);
            }

            Ratings updatedRatings=ratingsDao.updateRatings(ratings);
            ResponseStructure<Ratings> responseStructure=new ResponseStructure<>();
            responseStructure.setData(updatedRatings);
            responseStructure.setMessage("Ratings updated Successfully");
            responseStructure.setStatusCode(HttpStatus.OK.value());
            return new ResponseEntity<>(responseStructure,HttpStatus.OK);
        }
        else {
            throw new DataNotFoundException("Ratings is not found to update");
        }
    }
    @Override
    public ResponseEntity<ResponseStructure<String>> deleteRatings(int id) {
        Ratings ratings= ratingsDao.findRatingsById(id);
        if(ratings!=null)
        {
            ratings.setRecipe(null);
            String message=ratingsDao.deleteRatings(ratings);
            ResponseStructure<String> responseStructure=new ResponseStructure<>();
            responseStructure.setData(message);
            responseStructure.setMessage("Deleted Successfully");
            responseStructure.setStatusCode(HttpStatus.OK.value());
            return new ResponseEntity<>(responseStructure,HttpStatus.OK);
        }
        else {
            throw new DataNotFoundException("Ratings is not found to delete");
        }
    }

    @Override
    public ResponseEntity<ResponseStructure<List<Ratings>>> getAllRatingsList() {
        List<Ratings> ratingsList = ratingsDao.getAllRatingsList();
        if (!ratingsList.isEmpty()) {
            ResponseStructure<List<Ratings>> responseStructure = new ResponseStructure<>();
            responseStructure.setData(ratingsList);
            responseStructure.setMessage("All ratings fetched successfully");
            responseStructure.setStatusCode(HttpStatus.OK.value());
            return new ResponseEntity<>(responseStructure, HttpStatus.OK);
        } else {

            ResponseStructure<List<Ratings>> responseStructure = new ResponseStructure<>();
            responseStructure.setData(new ArrayList<>());
            responseStructure.setMessage("Ratings are not Present");
            responseStructure.setStatusCode(HttpStatus.OK.value());
            return new ResponseEntity<>(responseStructure, HttpStatus.OK);
        }
    }

    }
