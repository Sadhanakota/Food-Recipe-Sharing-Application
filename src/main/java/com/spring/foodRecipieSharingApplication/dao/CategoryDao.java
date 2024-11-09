package com.spring.foodRecipieSharingApplication.dao;

import com.spring.foodRecipieSharingApplication.models.entity.Category;

import java.util.List;

public interface CategoryDao {
    Category createCategory(Category category);
    Category findCategoryById(int id);
    Category updateCategory(Category category);
    String deleteCategory(Category category);
    List<Category> getAllCategoryList();
}
