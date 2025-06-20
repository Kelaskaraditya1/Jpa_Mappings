package com.StarkIndustries.SpringDataJpaMappings.oneToMany.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

@Entity(name = "product")
public class Product {

    /*
     * add one to many to the Parent Class and @JsonManagedReference also to the parent class to avoid from infinite recursion
     * use cascade=CascadeType.All property so that operation on Parent entity will effect on child entity as well like if parent is deleted than the related child entity will also be deleted.
     * * give @JsonManagereference to parent class in which we want the array of objects child class and give @JsonBackreference to child class so that it will not add it's parent in the response body.*/

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long productId;

    @Column(name = "name")
    private String  name;

    @Column(name = "quantity")
    private String quantity;

    @Column(name = "rate")
    private String rate;

    @Column(name = "amount")
    private String amount;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    @JsonBackReference
    private Customer customer;

    public Product(Long productId, String name, String quantity, String rate, String amount, Customer customer) {
        this.productId = productId;
        this.name = name;
        this.quantity = quantity;
        this.rate = rate;
        this.amount = amount;
        this.customer = customer;
    }

    public Product(Long productId, String name, String quantity, String rate, String amount) {
        this.productId = productId;
        this.name = name;
        this.quantity = quantity;
        this.rate = rate;
        this.amount = amount;
    }

    public Product(String name, String quantity, String rate, String amount) {
        this.name = name;
        this.quantity = quantity;
        this.rate = rate;
        this.amount = amount;
    }

    public Product() {

    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    public String getRate() {
        return rate;
    }

    public void setRate(String rate) {
        this.rate = rate;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "Product{" +
                "productId=" + productId +
                ", name='" + name + '\'' +
                ", quantity='" + quantity + '\'' +
                ", rate='" + rate + '\'' +
                ", amount='" + amount + '\'' +
                ", customer=" + customer +
                '}';
    }
}
