package com.StarkIndustries.SpringDataJpaMappings.manyToMany.dto;

import java.util.List;

public class ItemDto {

    private String itemName;

    private String itemPrice;

    private List<Long> categoryIds;

    public ItemDto(String itemName, String itemPrice, List<Long> categoryIds) {
        this.itemName = itemName;
        this.itemPrice = itemPrice;
        this.categoryIds = categoryIds;
    }

    public ItemDto(String itemName, String itemPrice) {
        this.itemName = itemName;
        this.itemPrice = itemPrice;
    }

    public ItemDto() {

    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getItemPrice() {
        return itemPrice;
    }

    public void setItemPrice(String itemPrice) {
        this.itemPrice = itemPrice;
    }

    public List<Long> getCategoryIds() {
        return categoryIds;
    }

    public void setCategoryIds(List<Long> categoryIds) {
        this.categoryIds = categoryIds;
    }

    @Override
    public String toString() {
        return "ItemDto{" +
                "itemName='" + itemName + '\'' +
                ", itemPrice='" + itemPrice + '\'' +
                ", categoryIds=" + categoryIds +
                '}';
    }
}
