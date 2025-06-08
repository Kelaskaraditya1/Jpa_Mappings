package com.StarkIndustries.SpringDataJpaMappings.manyToMany.controller;

import com.StarkIndustries.SpringDataJpaMappings.manyToMany.dto.ItemDto;
import com.StarkIndustries.SpringDataJpaMappings.manyToMany.models.Item;
import com.StarkIndustries.SpringDataJpaMappings.manyToMany.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ItemController {

    @Autowired
    public ItemService itemService;

    @PostMapping("/add-item")
    public ResponseEntity<?> addItem(@RequestBody ItemDto itemDto){
        Item item =  this.itemService.addItem(itemDto);
        if (item!=null)
            return ResponseEntity.status(HttpStatus.OK).body(item);
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Failed to add item!!");
    }

    @GetMapping("/get-item/{id}")
    public ResponseEntity<?> getItem(@PathVariable("id") Long itemId){
        Item item = this.itemService.getItem(itemId);
        if(item!=null)
            return ResponseEntity.status(HttpStatus.OK).body(item);
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Item doesn't exist!!");
    }

    @GetMapping("/get-items")
    public ResponseEntity<?> getItems(){
        List<Item> itemList = this.itemService.getItems();
        if(!itemList.isEmpty())
            return ResponseEntity.status(HttpStatus.OK).body(itemList);
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Enter items first!!");
    }

}
