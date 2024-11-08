package com.spring.foodRecipieSharingApplication.repository;

import com.spring.foodRecipieSharingApplication.models.entity.Recipe;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RecipeRepository extends JpaRepository<Recipe,Integer> {
}
