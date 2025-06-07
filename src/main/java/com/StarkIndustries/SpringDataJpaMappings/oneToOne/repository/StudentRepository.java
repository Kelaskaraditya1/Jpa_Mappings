package com.StarkIndustries.SpringDataJpaMappings.oneToOne.repository;

import com.StarkIndustries.SpringDataJpaMappings.oneToOne.models.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<Student,Long> {
}
