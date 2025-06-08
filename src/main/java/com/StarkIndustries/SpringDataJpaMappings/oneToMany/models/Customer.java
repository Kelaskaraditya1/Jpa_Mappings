package com.StarkIndustries.SpringDataJpaMappings.oneToMany.models;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.util.List;

@Entity(name = "Customer")
public class Customer {

    /*
     * add one to many to the Parent Class and @JsonManagedReference also to the parent class to avoid from infinite recursion
     * use cascade=CascadeType.All property so that operation on Parent entity will effect on child entity as well like if parent is deleted than the related child entity will also be deleted.
     * */

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long customerId;

    @Column(name="name")
    private String name;

    @Column(name = "email")
    private String email;

    @Column(name = "username")
    private String username;

    @OneToMany(mappedBy = "customer",cascade = CascadeType.ALL)
    @JsonManagedReference
    private List<Product> productList;

    public Customer(Long customerId, String name, String email, String username, List<Product> productList) {
        this.customerId = customerId;
        this.name = name;
        this.email = email;
        this.username = username;
        this.productList = productList;
    }

    public Customer(String name, String email, String username, List<Product> productList) {
        this.name = name;
        this.email = email;
        this.username = username;
        this.productList = productList;
    }

    public Customer(Long customerId, String name, String email, String username) {
        this.customerId = customerId;
        this.name = name;
        this.email = email;
        this.username = username;
    }

    public Customer() {

    }

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
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

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public List<Product> getProductList() {
        return productList;
    }

    public void setProductList(List<Product> productList) {
        this.productList = productList;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "customerId=" + customerId +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", username='" + username + '\'' +
                ", productList=" + productList +
                '}';
    }
}
