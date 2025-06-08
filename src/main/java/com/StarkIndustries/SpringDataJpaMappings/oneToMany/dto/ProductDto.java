package com.StarkIndustries.SpringDataJpaMappings.oneToMany.dto;

public class ProductDto {

    private String name;

    private String quantity;

    private String rate;

    private String amount;

    private Long customerId;

    public ProductDto(String name, String quantity, String rate, String amount, Long customerId) {
        this.name = name;
        this.quantity = quantity;
        this.rate = rate;
        this.amount = amount;
        this.customerId = customerId;
    }

    public ProductDto(String name, String quantity, String rate, String amount) {
        this.name = name;
        this.quantity = quantity;
        this.rate = rate;
        this.amount = amount;
    }

    public ProductDto() {

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

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    @Override
    public String toString() {
        return "ProductDto{" +
                "name='" + name + '\'' +
                ", quantity='" + quantity + '\'' +
                ", rate='" + rate + '\'' +
                ", amount='" + amount + '\'' +
                ", customerId=" + customerId +
                '}';
    }
}
