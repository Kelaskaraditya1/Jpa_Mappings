package com.StarkIndustries.SpringDataJpaMappings.OneToMany.service;

import com.StarkIndustries.SpringDataJpaMappings.OneToMany.models.Customer;
import com.StarkIndustries.SpringDataJpaMappings.OneToMany.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {

    @Autowired
    public CustomerRepository customerRepository;

    public Customer addCustomer(Customer customer){
        return this.customerRepository.save(customer);
    }

    public Customer getCustomer(Long customerId){
        if(this.customerRepository.existsById(customerId))
            return this.customerRepository.findById(customerId).get();
        return null;
    }

    public List<Customer> getCustomers(){
        return this.customerRepository.findAll();
    }

}
