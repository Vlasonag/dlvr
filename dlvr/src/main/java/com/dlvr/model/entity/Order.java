package com.dlvr.model.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;



@Entity
@Table(name="orders")
public class Order {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Long id;
    Long user_id;
	String description;
	String date;
	String deliver_date;
	public String user_telephone;
    public String user_address;
    String status;
    Long cook_id;
    Long courier_id;
    
	public Long getUser_id() {
		return user_id;
	}
	public void setUser_id(Long user_id) {
		this.user_id = user_id;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getDeliver_date() {
		return deliver_date;
	}
	public void setDeliver_date(String deliver_date) {
		this.deliver_date = deliver_date;
	}
	public String getUser_telephone() {
		return user_telephone;
	}
	public void setUser_telephone(String user_telephone) {
		this.user_telephone = user_telephone;
	}
	public String getUser_address() {
		return user_address;
	}
	public void setUser_address(String user_address) {
		this.user_address = user_address;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Long getCook_id() {
		return cook_id;
	}
	public void setCook_id(Long cook_id) {
		this.cook_id = cook_id;
	}
	public Long getCourier_id() {
		return courier_id;
	}
	public void setCourier_id(Long courier_id) {
		this.courier_id = courier_id;
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	@Override
	public String toString() {
		return "Время и дата заказа: " + date
				+ ", время и дата доставки: " + deliver_date;
	}
    
    
}
