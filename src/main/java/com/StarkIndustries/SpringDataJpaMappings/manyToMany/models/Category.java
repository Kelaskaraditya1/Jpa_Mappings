package com.StarkIndustries.SpringDataJpaMappings.manyToMany.models;

import com.StarkIndustries.SpringDataJpaMappings.oneToMany.models.Product;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.util.List;

@Entity(name = "category")
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long categoryId;

    public List<Item> getItemList() {
        return itemList;
    }

    public void setItemList(List<Item> itemList) {
        this.itemList = itemList;
    }

    @Column(name = "name")
    private String categoryName;

    @ManyToMany(mappedBy = "categoryList",cascade = CascadeType.ALL)
    @JsonManagedReference
    private List<Item> itemList;

    public Category(Long categoryId, String categoryName, List<Item> itemList) {
        this.categoryId = categoryId;
        this.categoryName = categoryName;
        this.itemList = itemList;
    }

    public Category(Long categoryId, String categoryName) {
        this.categoryId = categoryId;
        this.categoryName = categoryName;
    }

    public Category() {

    }

    public Long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }


    @Override
    public String toString() {
        return "Category{" +
                "categoryId=" + categoryId +
                ", categoryName='" + categoryName + '\'' +
                ", productList=" + itemList +
                '}';
    }
}
