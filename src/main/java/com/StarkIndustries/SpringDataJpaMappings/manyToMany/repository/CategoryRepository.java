package com.StarkIndustries.SpringDataJpaMappings.manyToMany.repository;

import com.StarkIndustries.SpringDataJpaMappings.manyToMany.models.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends JpaRepository<Category,Long> {
}
