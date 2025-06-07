package com.StarkIndustries.SpringDataJpaMappings.oneToOne.dto;

public class LaptopDto {

    private String company;

    private String model;

    private String price;

    private Long sid;

    public LaptopDto(String company, String model, String price, Long sid) {
        this.company = company;
        this.model = model;
        this.price = price;
        this.sid = sid;
    }

    public LaptopDto(String company, String model, String price) {
        this.company = company;
        this.model = model;
        this.price = price;
    }

    public LaptopDto(){

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

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public Long getSid() {
        return sid;
    }

    public void setSid(Long sid) {
        this.sid = sid;
    }

    @Override
    public String toString() {
        return "LaptopDto{" +
                "company='" + company + '\'' +
                ", model='" + model + '\'' +
                ", price='" + price + '\'' +
                ", sid=" + sid +
                '}';
    }
}
