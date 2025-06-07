package com.StarkIndustries.SpringDataJpaMappings.oneToOne.dto;

public class StudentDto {

    private String name;

    private String email;

    private String department;

    private Long laptopId;

    public StudentDto(String name, String email, String department, Long laptopId) {
        this.name = name;
        this.email = email;
        this.department = department;
        this.laptopId = laptopId;
    }

    public StudentDto(String name, String email, String department) {
        this.name = name;
        this.email = email;
        this.department = department;
    }

    public StudentDto(){

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public Long getLaptopId() {
        return laptopId;
    }

    public void setLaptopId(Long laptopId) {
        this.laptopId = laptopId;
    }

    @Override
    public String toString() {
        return "StudentDto{" +
                "name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", department='" + department + '\'' +
                ", laptopId=" + laptopId +
                '}';
    }
}
