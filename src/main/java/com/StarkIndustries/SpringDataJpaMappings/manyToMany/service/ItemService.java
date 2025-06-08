package com.StarkIndustries.SpringDataJpaMappings.manyToMany.service;

import com.StarkIndustries.SpringDataJpaMappings.manyToMany.dto.ItemDto;
import com.StarkIndustries.SpringDataJpaMappings.manyToMany.models.Category;
import com.StarkIndustries.SpringDataJpaMappings.manyToMany.models.Item;
import com.StarkIndustries.SpringDataJpaMappings.manyToMany.repository.CategoryRepository;
import com.StarkIndustries.SpringDataJpaMappings.manyToMany.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ItemService {

    @Autowired
    public ItemRepository itemRepository;

    @Autowired
    public CategoryRepository categoryRepository;

    public Item addItem(ItemDto itemDto){
        List<Long> categoryIds = itemDto.getCategoryIds();
        Item item = new Item();
        item.setItemName(itemDto.getItemName());
        item.setPrice(itemDto.getItemPrice());

        List<Category> categoryList = new ArrayList<>();

        categoryIds.stream().forEach(categoryId->{
            categoryList.add(this.categoryRepository.findById(categoryId).get());
        });

        item.setCategoryList(categoryList);
        this.itemRepository.save(item);
        return item;
    }

    public Item getItem(Long itemId){
        if(this.itemRepository.existsById(itemId))
            return this.itemRepository.findById(itemId).get();
        return null;
    }

    public List<Item> getItems(){
        return this.itemRepository.findAll();
    }


}
