package com.StarkIndustries.SpringDataJpaMappings.OneToMany.repository;

import com.StarkIndustries.SpringDataJpaMappings.OneToMany.models.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<Customer,Long> {
}
