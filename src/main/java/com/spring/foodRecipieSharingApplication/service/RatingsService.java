package com.spring.foodRecipieSharingApplication.service;

import com.spring.foodRecipieSharingApplication.models.dto.IngrediantsDto;
import com.spring.foodRecipieSharingApplication.models.dto.RatingsDto;
import com.spring.foodRecipieSharingApplication.models.dto.ResponseStructure;
import com.spring.foodRecipieSharingApplication.models.entity.Ingrediants;
import com.spring.foodRecipieSharingApplication.models.entity.Ratings;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface RatingsService {

    ResponseEntity<ResponseStructure<Ratings>> createRatings(RatingsDto ratingsDto);
    ResponseEntity<ResponseStructure<Ratings>> findRatingsById(int id);
    ResponseEntity<ResponseStructure<Ratings>> updateRatings(int id,RatingsDto ratingsDto);
    ResponseEntity<ResponseStructure<String>> deleteRatings(int id);
    ResponseEntity<ResponseStructure<List<Ratings>>>  getAllRatingsList();
}
