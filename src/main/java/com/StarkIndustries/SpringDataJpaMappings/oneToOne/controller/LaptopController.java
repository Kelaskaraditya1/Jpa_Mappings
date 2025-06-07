package com.StarkIndustries.SpringDataJpaMappings.oneToOne.controller;

import com.StarkIndustries.SpringDataJpaMappings.oneToOne.dto.LaptopDto;
import com.StarkIndustries.SpringDataJpaMappings.oneToOne.models.Laptop;
import com.StarkIndustries.SpringDataJpaMappings.oneToOne.service.LaptopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class LaptopController {

    @Autowired
    public LaptopService laptopService;

    @PostMapping("/add-laptop")
    public ResponseEntity<?> addLaptop(@RequestBody Laptop laptop){
        Laptop laptop1 = this.laptopService.addLaptop(laptop);
        if(laptop1!=null)
            return ResponseEntity.status(HttpStatus.OK).body(laptop1);
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to add Laptop!!");
    }

    @GetMapping("/get-laptop/{id}")
    public ResponseEntity<?> getLaptop(@PathVariable("id") Long laptopId){
        if(this.laptopService.getLaptop(laptopId)!=null)
            return ResponseEntity.status(HttpStatus.OK).body(this.laptopService.getLaptop(laptopId));
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Laptop doesn't exist");
    }

    @GetMapping("/get-laptops")
    public ResponseEntity<?> getLaptops(){
        List<Laptop> laptopList = this.laptopService.getLaptops();
        if(!laptopList.isEmpty())
            return ResponseEntity.status(HttpStatus.OK).body(laptopList);
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No Laptop entry!!");
    }
}
