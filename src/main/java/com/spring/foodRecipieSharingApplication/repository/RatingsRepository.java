package com.spring.foodRecipieSharingApplication.repository;

import com.spring.foodRecipieSharingApplication.models.entity.Ratings;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RatingsRepository extends JpaRepository<Ratings, Integer> {
}
