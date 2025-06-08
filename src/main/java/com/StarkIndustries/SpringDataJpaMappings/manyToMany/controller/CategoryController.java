package com.StarkIndustries.SpringDataJpaMappings.manyToMany.controller;

import com.StarkIndustries.SpringDataJpaMappings.manyToMany.models.Category;
import com.StarkIndustries.SpringDataJpaMappings.manyToMany.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CategoryController {

    @Autowired
    public CategoryService categoryService;

    @PostMapping("/add-category")
    public ResponseEntity<?> addCategory(@RequestBody Category category){
        Category category1 = this.categoryService.addCategory(category);
        if(category1!=null)
            return ResponseEntity.status(HttpStatus.OK).body(category1);
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to add Category");
    }

    @GetMapping("/get-category/{id}")
    public ResponseEntity<?> getCategory(@PathVariable("id") Long categoryId){
        Category category = this.categoryService.getCategory(categoryId);
        if(category!=null)
            return ResponseEntity.status(HttpStatus.OK).body(category);
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Category doesn't exist!!");
    }

    @GetMapping("/get-categories")
    public ResponseEntity<?> getCategories(){
        List<Category> categoryList = this.categoryService.getCategories();
        if(!categoryList.isEmpty())
            return ResponseEntity.status(HttpStatus.OK).body(categoryList);
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Enter categories first!!");
    }

}
