package com.dlvr.model.repository;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.dlvr.model.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Long>{
	
	@Query("SELECT name FROM Product name WHERE name.id = :id")
	Product findNameById(@Param("id") Long id);
	
	
}
