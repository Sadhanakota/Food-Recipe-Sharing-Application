package com.spring.foodRecipieSharingApplication.service;

import com.spring.foodRecipieSharingApplication.dao.CategoryDao;
import com.spring.foodRecipieSharingApplication.models.dto.CategoryDto;
import com.spring.foodRecipieSharingApplication.models.dto.IngrediantsDto;
import com.spring.foodRecipieSharingApplication.models.dto.ResponseStructure;
import com.spring.foodRecipieSharingApplication.models.entity.Category;
import com.spring.foodRecipieSharingApplication.models.entity.Ingrediants;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface CategoryService {

    ResponseEntity<ResponseStructure<Category>> createCategory(CategoryDto categoryDto);
    ResponseEntity<ResponseStructure<Category>> findCategoryById(int id);
    ResponseEntity<ResponseStructure<Category>> updateCategory(int id, CategoryDto categoryDto);
    //ResponseEntity<ResponseStructure<String>> deleteCategory(int id);
    ResponseEntity<ResponseStructure<List<Category>>>  getAllCategoryList();
}
