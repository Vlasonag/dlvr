package com.dlvr.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dlvr.model.entity.Wish;

public interface WishRepository  extends JpaRepository<Wish, Long>{
	

}
