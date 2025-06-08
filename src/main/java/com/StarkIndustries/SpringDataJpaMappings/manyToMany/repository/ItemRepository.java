package com.StarkIndustries.SpringDataJpaMappings.manyToMany.repository;

import com.StarkIndustries.SpringDataJpaMappings.manyToMany.models.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemRepository extends JpaRepository<Item,Long> {
}
