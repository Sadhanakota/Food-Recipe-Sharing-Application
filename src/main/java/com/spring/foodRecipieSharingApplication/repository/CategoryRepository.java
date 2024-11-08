package com.spring.foodRecipieSharingApplication.repository;

import com.spring.foodRecipieSharingApplication.models.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category,Integer> {
}
