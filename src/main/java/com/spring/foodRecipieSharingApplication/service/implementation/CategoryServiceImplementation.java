package com.spring.foodRecipieSharingApplication.service.implementation;

import com.spring.foodRecipieSharingApplication.dao.CategoryDao;
import com.spring.foodRecipieSharingApplication.exception.DataNotFoundException;
import com.spring.foodRecipieSharingApplication.models.dto.CategoryDto;
import com.spring.foodRecipieSharingApplication.models.dto.IngrediantsDto;
import com.spring.foodRecipieSharingApplication.models.dto.ResponseStructure;
import com.spring.foodRecipieSharingApplication.models.entity.Category;
import com.spring.foodRecipieSharingApplication.models.entity.Ingrediants;
import com.spring.foodRecipieSharingApplication.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CategoryServiceImplementation implements CategoryService {

    @Autowired
    private CategoryDao categoryDao;

    @Override
    public ResponseEntity<ResponseStructure<Category>> createCategory(CategoryDto categoryDto){
        Category category = new Category();
        category.setName(categoryDto.getName());
        ResponseStructure<Category> responseStructure = new ResponseStructure<>();
        responseStructure.setData(categoryDao.createCategory(category));
        responseStructure.setMessage("Category Created Successfully");
        responseStructure.setStatusCode(HttpStatus.CREATED.value());
        return new ResponseEntity<>(responseStructure,HttpStatus.CREATED);

    }


    @Override
    public ResponseEntity<ResponseStructure<Category>> findCategoryById(int id) {
      Category category=categoryDao.findCategoryById(id);
        if(category!=null)
        {
            ResponseStructure<Category> responseStructure=new ResponseStructure<>();
            responseStructure.setStatusCode(HttpStatus.FOUND.value());
            responseStructure.setMessage("Category fetched succesfully");
            responseStructure.setData(category);
            return new ResponseEntity<>(responseStructure,HttpStatus.FOUND);
        }
        else{
            throw new DataNotFoundException("Category is not found");
        }
    }
    @Override
    public ResponseEntity<ResponseStructure<Category>> updateCategory(int id, CategoryDto categoryDto) {

       Category category=categoryDao.findCategoryById(id);
        if(category!=null)
        {
            String name= categoryDto.getName();
            if(name!=null) {
                category.setName(name);
            }
            Category updatedCategory=categoryDao.updateCategory(category);
            ResponseStructure<Category> responseStructure=new ResponseStructure<>();
            responseStructure.setData(updatedCategory);
            responseStructure.setMessage("Category updated Successfully");
            responseStructure.setStatusCode(HttpStatus.OK.value());
            return new ResponseEntity<>(responseStructure,HttpStatus.OK);
        }
        else {
            throw new DataNotFoundException("Category is not found to update");
        }
    }
//@Override
//    public ResponseEntity<ResponseStructure<String>> deleteCategory(int id ){
//        Category category = categoryDao.findCategoryById(id);
//        if(category!=null){
//            ResponseStructure<String> responseStructure = new ResponseStructure<>();
//            responseStructure.setData(categoryDao.deleteCategory(category));
//            responseStructure.setMessage("Category is not found to delete");
//            responseStructure.setStatusCode(HttpStatus.OK.value());
//            return new ResponseEntity<>(responseStructure,HttpStatus.OK);
//
//        }
//        else {
//            throw new DataNotFoundException("Category is not found to update");
//        }
//}
    @Override
    public ResponseEntity<ResponseStructure<List<Category>>> getAllCategoryList() {
        List<Category> categoryList = categoryDao.getAllCategoryList();
        if (!categoryList.isEmpty()) {
            ResponseStructure<List<Category>> responseStructure = new ResponseStructure<>();
            responseStructure.setData(categoryList);
            responseStructure.setMessage("All Category fetched successfully");
            responseStructure.setStatusCode(HttpStatus.OK.value());
            return new ResponseEntity<>(responseStructure, HttpStatus.OK);
        } else {

            ResponseStructure<List<Category>> responseStructure = new ResponseStructure<>();
            responseStructure.setData(new ArrayList<>());
            responseStructure.setMessage("category is not Present");
            responseStructure.setStatusCode(HttpStatus.OK.value());
            return new ResponseEntity<>(responseStructure, HttpStatus.OK);
        }

    }


}
