package com.StarkIndustries.SpringDataJpaMappings.oneToOne.service;

import com.StarkIndustries.SpringDataJpaMappings.oneToOne.dto.LaptopDto;
import com.StarkIndustries.SpringDataJpaMappings.oneToOne.dto.StudentDto;
import com.StarkIndustries.SpringDataJpaMappings.oneToOne.models.Laptop;
import com.StarkIndustries.SpringDataJpaMappings.oneToOne.models.Student;
import com.StarkIndustries.SpringDataJpaMappings.oneToOne.repository.LaptopRepository;
import com.StarkIndustries.SpringDataJpaMappings.oneToOne.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    @Autowired
    public StudentRepository studentRepository;

    @Autowired
    public LaptopRepository laptopRepository;

    public Student addStudent(StudentDto studentDto){
        if(this.laptopRepository.existsById(studentDto.getLaptopId())){
            Laptop laptop = this.laptopRepository.findById(studentDto.getLaptopId()).get();
            Student student = new Student();
            student.setName(studentDto.getName());
            student.setDepartment(studentDto.getDepartment());
            student.setEmail(studentDto.getEmail());
            student.setLaptop(laptop);
            this.studentRepository.save(student);
            return student;
        }
        return null;
    }

    public Student getStudent(Long studentId){
        if(this.studentRepository.existsById(studentId))
            return this.studentRepository.findById(studentId).get();
        return null;
    }

    public List<Student> getStudents(){
        return this.studentRepository.findAll();
    }
}
