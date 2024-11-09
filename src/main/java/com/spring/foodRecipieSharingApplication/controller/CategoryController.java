package com.spring.foodRecipieSharingApplication.controller;

import com.spring.foodRecipieSharingApplication.models.dto.CategoryDto;
import com.spring.foodRecipieSharingApplication.models.dto.ResponseStructure;
import com.spring.foodRecipieSharingApplication.models.entity.Category;
import com.spring.foodRecipieSharingApplication.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/category")
@RestController
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @PostMapping("/create")
    public ResponseEntity<ResponseStructure<Category>> createCategory(@RequestBody CategoryDto categoryDto){
        return categoryService.createCategory(categoryDto);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<ResponseStructure<Category>> findCategoryById(@PathVariable int id){
        return categoryService.findCategoryById(id);
    }
    @PutMapping("/update/{id}")
    public ResponseEntity<ResponseStructure<Category>> updateCategory(@PathVariable int id, @RequestBody CategoryDto categoryDto){
        return categoryService.updateCategory(id, categoryDto);
    }

//    @DeleteMapping("/delete/{id}")
//    public ResponseEntity<ResponseStructure<String>> deleteCategory(@PathVariable int id){
//        return categoryService.deleteCategory(id);
//    }

    @GetMapping("/getAll")
    public ResponseEntity<ResponseStructure<List<Category>>> getAllCategoryList(){
        return categoryService.getAllCategoryList();
    }


}
