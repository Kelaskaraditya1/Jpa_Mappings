package com.StarkIndustries.SpringDataJpaMappings.OneToMany.controller;

import com.StarkIndustries.SpringDataJpaMappings.OneToMany.models.Customer;
import com.StarkIndustries.SpringDataJpaMappings.OneToMany.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CustomerController {

    @Autowired
    public CustomerService customerService;

    @PostMapping("/add-customer")
    public ResponseEntity<?> addCustomer(@RequestBody Customer customer){
        Customer customer1 = this.customerService.addCustomer(customer);
        if(customer1!=null)
            return ResponseEntity.status(HttpStatus.OK).body(customer1);
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to add Customer!!");
    }

    @GetMapping("/get-customer/{id}")
    public ResponseEntity<?> getCustomer(@PathVariable("id") Long customerId){
        Customer customer = this.customerService.getCustomer(customerId);
        if(customer!=null)
            return ResponseEntity.status(HttpStatus.OK).body(customer);
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Customer doesn't exist");
    }

    @GetMapping("/get-customers")
    public ResponseEntity<?> getCustomers(){
        List<Customer> customerList = this.customerService.getCustomers();
        if(!customerList.isEmpty())
            return ResponseEntity.status(HttpStatus.OK).body(customerList);
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Enter customer's first!!");
    }

}
