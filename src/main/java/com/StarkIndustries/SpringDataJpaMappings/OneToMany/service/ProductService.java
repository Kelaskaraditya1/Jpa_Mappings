package com.StarkIndustries.SpringDataJpaMappings.OneToMany.service;

import com.StarkIndustries.SpringDataJpaMappings.OneToMany.dto.ProductDto;
import com.StarkIndustries.SpringDataJpaMappings.OneToMany.models.Customer;
import com.StarkIndustries.SpringDataJpaMappings.OneToMany.models.Product;
import com.StarkIndustries.SpringDataJpaMappings.OneToMany.repository.CustomerRepository;
import com.StarkIndustries.SpringDataJpaMappings.OneToMany.repository.ProductRepository;
import org.apache.catalina.LifecycleState;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    public ProductRepository productRepository;

    @Autowired
    public CustomerRepository customerRepository;

    public Product addProduct(ProductDto productDto){
        if(this.customerRepository.existsById(productDto.getCustomerId())){
            Customer customer = this.customerRepository.findById(productDto.getCustomerId()).get();
            Product product = new Product();
            product.setName(productDto.getName());
            product.setAmount(productDto.getAmount());
            product.setRate(productDto.getRate());
            product.setQuantity(productDto.getQuantity());
            product.setCustomer(customer);
            this.productRepository.save(product);
            return product;
        }
        return null;
    }

    public Product getProduct(Long productId){
        if(this.productRepository.existsById(productId))
            return this.productRepository.findById(productId).get();
        return null;
    }

    public List<Product> getProducts(){
        return this.productRepository.findAll();
    }

}
