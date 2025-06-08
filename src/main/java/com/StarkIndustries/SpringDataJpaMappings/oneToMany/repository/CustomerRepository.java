package com.StarkIndustries.SpringDataJpaMappings.oneToMany.repository;

import com.StarkIndustries.SpringDataJpaMappings.oneToMany.models.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<Customer,Long> {
}
