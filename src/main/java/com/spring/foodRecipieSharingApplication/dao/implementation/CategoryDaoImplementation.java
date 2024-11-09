package com.spring.foodRecipieSharingApplication.dao.implementation;

import com.spring.foodRecipieSharingApplication.dao.CategoryDao;
import com.spring.foodRecipieSharingApplication.models.entity.Category;
import com.spring.foodRecipieSharingApplication.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class CategoryDaoImplementation implements CategoryDao{
    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public Category createCategory(Category category){
        return categoryRepository.save(category);
    }
    @Override
    public Category findCategoryById(int id){
        Optional category = categoryRepository.findById(id);
        if (category.isPresent()){
            return (Category) category.get();
        }else {
            return null;
        }
    }

    @Override
    public Category updateCategory(Category category){
        return categoryRepository.save(category);
    }
    @Override
    public String deleteCategory(Category category){
        categoryRepository.delete(category);
        return "Category is deleted";
    }
    @Override
    public List<Category> getAllCategoryList(){
        return categoryRepository.findAll();
    }



}
