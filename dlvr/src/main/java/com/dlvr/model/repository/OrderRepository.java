package com.dlvr.model.repository;

import java.util.ArrayList;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.dlvr.model.entity.Order;
import com.dlvr.model.entity.User;


public interface OrderRepository  extends JpaRepository<Order, Long>{
	@Query("SELECT name FROM Order name WHERE name.user_id = :user_id ")
	ArrayList<Order> findOrdersById(@Param("user_id") Long user_id);
	
	@Query("SELECT name FROM Order name WHERE name.user_id = :user_id AND name.status = 'delivered'")
	ArrayList<Order> findDeliveredOrdersById(@Param("user_id") Long user_id);
	
	@Query("SELECT name FROM Order name WHERE name.user_id = :user_id AND name.status != 'delivered'")
	ArrayList<Order> findNotDeliveredOrdersById(@Param("user_id") Long user_id);
	
	@Query("SELECT name FROM Order name WHERE name.cook_id = :cook_id ")
	ArrayList<Order> findOrdersByCookId(@Param("cook_id") Long cook_id);
	
	@Query("SELECT name FROM Order name WHERE name.courier_id = :courier_id ")
	ArrayList<Order> findOrdersByCourierId(@Param("courier_id") Long courier_id);
	
	@Query("SELECT c FROM Order c WHERE c.status = :status")
	ArrayList<Order> findOrdersWithStatus(@Param("status") String status);
	
	@Modifying
	@Query("UPDATE Order name SET name.cook_id = :cook_id, name.status = 'cooking' WHERE name.id = :id")
	@Transactional
	void assignCook(@Param("cook_id") Long cook_id, @Param("id") Long id);

	@Modifying
	@Query("UPDATE Order name SET name.courier_id = :courier_id, name.status = 'delivering' WHERE name.id = :id")
	@Transactional
	void assignCourier(@Param("courier_id") Long courier_id, @Param("id") Long id);
	
	@Modifying
	@Query("UPDATE Order name SET name.status = :status WHERE name.id = :id")
	@Transactional
	void setStatus(@Param("status") String status, @Param("id") Long id);
}
