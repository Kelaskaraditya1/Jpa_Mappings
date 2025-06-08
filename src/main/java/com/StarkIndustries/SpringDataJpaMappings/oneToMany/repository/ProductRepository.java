package com.StarkIndustries.SpringDataJpaMappings.oneToMany.repository;

import com.StarkIndustries.SpringDataJpaMappings.oneToMany.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product,Long> {
}
