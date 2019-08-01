package com.dlvr.model.repository;

import java.util.ArrayList;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.dlvr.model.entity.Product;
import com.dlvr.model.entity.User;

public interface UserRepository extends JpaRepository<User, Long>{
	
	@Query("SELECT CASE WHEN COUNT(c) > 0 THEN true ELSE false END FROM User c WHERE c.login = :login")
	 boolean isLoginExist(@Param("login") String login);
	
	@Query("SELECT CASE WHEN COUNT(c) > 0 THEN true ELSE false END FROM User c WHERE c.password = :password")
	 boolean isPasswordExist(@Param("password") String password);
	
	@Query("SELECT CASE WHEN COUNT(c) > 0 THEN true ELSE false END FROM User c WHERE c.password = :password AND c.login = :login")
	 boolean isUserExist(@Param("password") String password, @Param("login") String login);
	
	@Query("SELECT c FROM User c WHERE c.login = :login")
	User findIdByName(@Param("login") String login);
	
	@Query("SELECT c FROM User c WHERE c.role = :role AND c.isfree = 1")
	ArrayList<User> findFreeWorkers(@Param("role") String role);
	
	@Modifying
	@Query("Delete FROM User c WHERE c.id = :id and c.role = :role")
	@Transactional
	void deleteByIdAndRole(@Param("id") Long id, @Param("role") String role);
	
	@Modifying
	@Query("UPDATE User name SET name.login = :login WHERE name.id = :id")
	@Transactional
	void setLogin(@Param("id") Long user_id, @Param("login") String login);
	
	@Modifying
	@Query("UPDATE User name SET name.telephone = :telephone WHERE name.id = :id")
	@Transactional
	void setTelephone(@Param("id") Long id, @Param("telephone") String telephone);
	
	@Modifying
	@Query("UPDATE User name SET name.address = :address WHERE name.id = :id")
	@Transactional
	void setAddress(@Param("id") Long id, @Param("address") String address);
	
	@Modifying
	@Query("UPDATE User name SET name.isfree = 0 WHERE name.id = :id")
	@Transactional
	void setUserBusyById(@Param("id") Long id);
	
	@Modifying
	@Query("UPDATE User name SET name.isfree = 1 WHERE name.id = :id")
	@Transactional
	void setUserFreeById(@Param("id") Long id);
}
