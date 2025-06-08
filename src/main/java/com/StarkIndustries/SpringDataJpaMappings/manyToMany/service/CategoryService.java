package com.StarkIndustries.SpringDataJpaMappings.manyToMany.service;

import com.StarkIndustries.SpringDataJpaMappings.manyToMany.models.Category;
import com.StarkIndustries.SpringDataJpaMappings.manyToMany.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {

    @Autowired
    public CategoryRepository categoryRepository;

    public Category addCategory(Category category){
        return this.categoryRepository.save(category);
    }

    public Category getCategory(Long categoryId){
        if(this.categoryRepository.existsById(categoryId))
            return this.categoryRepository.findById(categoryId).get();
        return null;
    }

    public List<Category> getCategories(){
        return this.categoryRepository.findAll();
    }
}
