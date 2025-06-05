package com.StarkIndustries.SpringDataJpaMappings.oneToOne.models;

import jakarta.persistence.*;

@Entity
@Table(name = "Laptop")
public class Laptop {

    /* for uni directional mapping: One to One annotation for one object having single relation with another object, use @JoinColumn(name="...") to take one tables primary key as foreign key
     * for by directional mapping we have to give one to one annotation in both the tables , so jpa creates foreign key for both tables 1st primary key in 2nd and 2nd primary key in 1st
     * if we want only one foreign key in one table give OneToOne(mappedBy="fieldName") in opposite table
     * for eg if want to have laptop_id as foreign key in students so mark @OneToOne(mappedBy="laptop") over Student attribute in Laptop table.*/

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long laptopId;

    @Column(name = "company")
    private String company;

    @Column(name = "model")
    private String model;

    @Column(name = "price")
    private Long price;

    @OneToOne(mappedBy = "laptop")
    @JoinColumn(name = "sid")
    private Student student;

    public Laptop(Long laptopId, String company, String model, Long price) {
        this.laptopId = laptopId;
        this.company = company;
        this.model = model;
        this.price = price;
    }

    public Laptop(String company, String model, Long price) {
        this.company = company;
        this.model = model;
        this.price = price;
    }

    public Laptop(){

    }

    public Long getLaptopId() {
        return laptopId;
    }

    public void setLaptopId(Long laptopId) {
        this.laptopId = laptopId;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Long getPrice() {
        return price;
    }

    public void setPrice(Long price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Laptop{" +
                "laptopId=" + laptopId +
                ", company='" + company + '\'' +
                ", model='" + model + '\'' +
                ", price=" + price +
                '}';
    }
}
