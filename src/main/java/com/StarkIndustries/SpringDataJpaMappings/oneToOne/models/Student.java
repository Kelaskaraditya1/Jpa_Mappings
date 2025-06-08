package com.StarkIndustries.SpringDataJpaMappings.oneToOne.models;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

@Entity
@Table(name = "Student")
public class Student {

    /* for uni directional mapping: One to One annotation for one object having single relation with another object, use @JoinColumn(name="...") to take one tables primary key as foreign key
    * for by directional mapping: we have to give one to one annotation in both the tables , so jpa creates foreign key for both tables 1st primary key in 2nd and 2nd primary key in 1st
    * if we want only one foreign key in one table give OneToOne(mappedBy="fieldName") in opposite table
    * for eg if want to have laptop_id as foreign key in students so mark @OneToOne(mappedBy="laptop") over Student attribute in Laptop table.*/

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long sid;

    @Column(name = "name")
    private String name;

    @Column(name = "department")
    private String department;

    @Column(name = "email")
    private String email;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "laptop_id")
    @JsonManagedReference
    private Laptop laptop;

    public Student(Long sid, String name, String department, String email, Laptop laptop) {
        this.sid = sid;
        this.name = name;
        this.department = department;
        this.email = email;
        this.laptop = laptop;
    }

    public Student(Long sid, String name, String department, String email) {
        this.sid = sid;
        this.name = name;
        this.department = department;
        this.email = email;
    }


    public Student(String name, String department, String email) {
        this.name = name;
        this.department = department;
        this.email = email;
    }

    public Student() {
    }

    public Long getSid() {
        return sid;
    }

    public void setSid(Long sid) {
        this.sid = sid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Laptop getLaptop() {
        return laptop;
    }

    public void setLaptop(Laptop laptop) {
        this.laptop = laptop;
    }

    @Override
    public String toString() {
        return "Student{" +
                "sid=" + sid +
                ", name='" + name + '\'' +
                ", department='" + department + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
