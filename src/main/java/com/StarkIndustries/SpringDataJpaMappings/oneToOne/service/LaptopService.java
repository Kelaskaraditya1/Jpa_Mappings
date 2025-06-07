package com.StarkIndustries.SpringDataJpaMappings.oneToOne.service;

import com.StarkIndustries.SpringDataJpaMappings.oneToOne.dto.LaptopDto;
import com.StarkIndustries.SpringDataJpaMappings.oneToOne.models.Laptop;
import com.StarkIndustries.SpringDataJpaMappings.oneToOne.models.Student;
import com.StarkIndustries.SpringDataJpaMappings.oneToOne.repository.LaptopRepository;
import com.StarkIndustries.SpringDataJpaMappings.oneToOne.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LaptopService {

    @Autowired
    public LaptopRepository laptopRepository;

    @Autowired
    public StudentRepository studentRepository;

    public Laptop addLaptop(Laptop laptop){
//        Student student = this.studentRepository.findById(laptopDto.getSid()).get();
//        if(student!=null){
//            Laptop laptop = new Laptop();
//            laptop.setCompany(laptopDto.getCompany());
//            laptop.setModel(laptopDto.getModel());
//            laptop.setPrice(laptopDto.getPrice());
//            laptop.setStudent(student);
//            laptopRepository.save(laptop);
//        }
//        return true;

        return this.laptopRepository.save(laptop);

    }

    public Laptop getLaptop(Long laptopId){
        if(this.laptopRepository.existsById(laptopId))
            return this.laptopRepository.findById(laptopId).get();
        return null;
    }

    public List<Laptop> getLaptops(){
        return this.laptopRepository.findAll();
    }
}
