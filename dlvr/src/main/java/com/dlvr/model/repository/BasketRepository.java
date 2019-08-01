package com.dlvr.model.repository;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.dlvr.model.entity.Basket;

public interface BasketRepository extends JpaRepository<Basket, Long>{
	
	@Query("SELECT name FROM Basket name WHERE name.user_id = :user_id AND name.product_name = :product_name")
	Basket findByUser_IdAndProduct_name(@Param("user_id") Long user_id, @Param("product_name") String product_name);
	
	@Query("SELECT CASE WHEN COUNT(c) > 0 THEN true ELSE false END "
			+ "FROM Basket c WHERE c.user_id = :user_id and c.product_name = :product_name")
	boolean isExist(@Param("user_id") Long user_id,@Param("product_name") String product_name);
	
	@Modifying
	@Query("UPDATE Basket name SET name.count = :count WHERE name.user_id = :user_id AND name.product_name = :product_name")
	@Transactional
	void increaseCount(@Param("user_id") Long user_id, @Param("product_name") String product_name, @Param("count") int count);

	@Query("SELECT name FROM Basket name WHERE name.user_id = :user_id")
	ArrayList<Basket> findBasketsById(@Param("user_id") Long user_id);
	
	@Modifying
	@Query("Delete FROM Basket c WHERE c.user_id = :user_id")
	@Transactional
	void deleteByUser_Id(@Param("user_id") Long user_id);
}
