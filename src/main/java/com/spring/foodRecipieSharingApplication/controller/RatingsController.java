package com.spring.foodRecipieSharingApplication.controller;

import com.spring.foodRecipieSharingApplication.dao.RatingsDao;
import com.spring.foodRecipieSharingApplication.models.dto.RatingsDto;
import com.spring.foodRecipieSharingApplication.models.dto.ResponseStructure;
import com.spring.foodRecipieSharingApplication.models.entity.Ratings;
import com.spring.foodRecipieSharingApplication.service.RatingsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/ratings")
public class RatingsController {

    @Autowired
    private RatingsService ratingsService;


    @PostMapping("/create/{recipeId}")
    public ResponseEntity<ResponseStructure<Ratings>> createRatings(@PathVariable int recipeId,@RequestBody RatingsDto ratingsDto) {
        return ratingsService.createRatings(recipeId,ratingsDto);

    }

    @GetMapping("/find/{id}")
    public ResponseEntity<ResponseStructure<Ratings>> findRatingById(@PathVariable int id) {
        return ratingsService.findRatingsById(id);

    }

    @PutMapping("/update/{id}")
    public ResponseEntity<ResponseStructure<Ratings>> updateRatings(@PathVariable int id, @RequestBody RatingsDto ratingsDto) {
        return ratingsService.updateRatings(id,ratingsDto);

    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<ResponseStructure<String>> deleteRatings(@PathVariable int id) {

        return ratingsService.deleteRatings(id);

    }
    @GetMapping("/getAll")
    public ResponseEntity<ResponseStructure<List<Ratings>>> getAllRatingsList() {

        return ratingsService.getAllRatingsList();

    }

}
