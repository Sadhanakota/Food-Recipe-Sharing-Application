package com.spring.foodRecipieSharingApplication.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spring.foodRecipieSharingApplication.models.entity.Ingrediants;

public interface IngrediantsRepository extends JpaRepository<Ingrediants, Integer> {

}
