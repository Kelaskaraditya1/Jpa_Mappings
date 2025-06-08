package com.StarkIndustries.SpringDataJpaMappings.oneToMany.controller;

import com.StarkIndustries.SpringDataJpaMappings.oneToMany.dto.ProductDto;
import com.StarkIndustries.SpringDataJpaMappings.oneToMany.models.Product;
import com.StarkIndustries.SpringDataJpaMappings.oneToMany.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductController {

    @Autowired
    public ProductService productService;

    @PostMapping("/add-product")
    public ResponseEntity<?> addProduct(@RequestBody ProductDto productDto){
        Product product = this.productService.addProduct(productDto);
        if(product!=null)
            return ResponseEntity.status(HttpStatus.OK).body(product);
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to add Product!!");
    }

    @GetMapping("/get-product/{id}")
    public ResponseEntity<?> getProduct(@PathVariable("id") Long productId){
        Product product = this.productService.getProduct(productId);
        if(product!=null)
            return ResponseEntity.status(HttpStatus.OK).body(product);
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Product doesn't exist!!");
    }

    @GetMapping("/get-products")
    public ResponseEntity<?> getProducts(){
        List<Product> productList = this.productService.getProducts();
        if(!productList.isEmpty())
            return ResponseEntity.status(HttpStatus.OK).body(productList);
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Enter product's first!!");
    }
}
