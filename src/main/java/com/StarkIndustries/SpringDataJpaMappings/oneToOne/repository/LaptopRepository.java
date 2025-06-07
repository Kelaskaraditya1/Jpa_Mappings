package com.StarkIndustries.SpringDataJpaMappings.oneToOne.repository;

import com.StarkIndustries.SpringDataJpaMappings.oneToOne.models.Laptop;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LaptopRepository extends JpaRepository<Laptop,Long> {
}
