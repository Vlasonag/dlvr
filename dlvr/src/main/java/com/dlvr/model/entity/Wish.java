package com.dlvr.model.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@javax.persistence.Table(name="wishes")
public class Wish {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;
	public Long user_id;
	public String wish;
	public Long getUser_id() {
		return user_id;
	}
	public void setUser_id(Long user_id) {
		this.user_id = user_id;
	}
	public String getWish() {
		return wish;
	}
	public void setWish(String wish) {
		this.wish = wish;
	}
	@Override
	public String toString() {
		return wish;
	}
	
	
}
