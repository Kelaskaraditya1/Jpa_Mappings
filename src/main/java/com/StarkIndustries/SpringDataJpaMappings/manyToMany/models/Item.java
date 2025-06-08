package com.StarkIndustries.SpringDataJpaMappings.manyToMany.models;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.util.List;

@Entity(name = "item")
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long itemId;

    @Column(name = "name")
    private String itemName;

    @Column(name = "price")
    private String price;

    @ManyToMany
    @JsonBackReference
    private List<Category> categoryList;

    public Item(Long itemId, String itemName, String price, List<Category> categoryList) {
        this.itemId = itemId;
        this.itemName = itemName;
        this.price = price;
        this.categoryList = categoryList;
    }

    public Item(Long itemId, String itemName, String price) {
        this.itemId = itemId;
        this.itemName = itemName;
        this.price = price;
    }

    public Item() {

    }

    public Long getItemId() {
        return itemId;
    }

    public void setItemId(Long itemId) {
        this.itemId = itemId;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public List<Category> getCategoryList() {
        return categoryList;
    }

    public void setCategoryList(List<Category> categoryList) {
        this.categoryList = categoryList;
    }

    @Override
    public String toString() {
        return "Item{" +
                "itemId=" + itemId +
                ", itemName='" + itemName + '\'' +
                ", price='" + price + '\'' +
                ", categoryList=" + categoryList +
                '}';
    }
}
