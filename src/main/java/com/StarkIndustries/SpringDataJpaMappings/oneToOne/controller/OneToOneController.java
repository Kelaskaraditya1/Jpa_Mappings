package com.StarkIndustries.SpringDataJpaMappings.oneToOne.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OneToOneController {

    @GetMapping("/greetings")
    public ResponseEntity<?> greetings(){
        return ResponseEntity.status(HttpStatus.OK).body("Greetings, I am Optimus Prime!!");
    }

}
