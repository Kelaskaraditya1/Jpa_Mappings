package com.StarkIndustries.SpringDataJpaMappings.oneToOne.controller;

import com.StarkIndustries.SpringDataJpaMappings.oneToOne.dto.StudentDto;
import com.StarkIndustries.SpringDataJpaMappings.oneToOne.models.Student;
import com.StarkIndustries.SpringDataJpaMappings.oneToOne.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StudentController {

    @Autowired
    public StudentService studentService;

    @PostMapping("/add-student")
    public ResponseEntity<?> addStudent(@RequestBody StudentDto studentDto){
        Student student1 = this.studentService.addStudent(studentDto);
        if(student1!=null)
            return ResponseEntity.status(HttpStatus.OK).body(student1);
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to add Student!!");
    }

    @GetMapping("/get-student/{id}")
    public ResponseEntity<?> getStudent(@PathVariable("id") Long sid){
        if(this.studentService.getStudent(sid)!=null)
            return ResponseEntity.status(HttpStatus.OK).body(this.studentService.getStudent(sid));
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Student doesn't exist");
    }

    @GetMapping("/get-students")
    public ResponseEntity<?> getStudents(){
        List<Student> studentList = this.studentService.getStudents();
        if(!studentList.isEmpty())
            return ResponseEntity.status(HttpStatus.OK).body(studentList);
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No Student entry!!");

    }
}
