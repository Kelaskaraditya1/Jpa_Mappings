package com.StarkIndustries.SpringDataJpaMappings.OneToMany.repository;

import com.StarkIndustries.SpringDataJpaMappings.OneToMany.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product,Long> {
}
