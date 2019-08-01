package com.dlvr.model.entity;

import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Entity; 
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;


@Entity
@Table(name="baskets")
public class Basket {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Long id;
	String product_name;
    Long user_id;
	Double product_price;
	int count;
	String product_img;
	
	
	/*@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "id", insertable = false, updatable = false)
    User user;
	*/
	public Long getUser_id() {
		return user_id;
	}
	public void setUser_id(Long user_id) {
		this.user_id = user_id;
	}
	public String getProduct_name() {
		return product_name;
	}
	public void setProduct_name(String product_name) {
		this.product_name = product_name;
	}
	public Double getProduct_price() {
		return product_price;
	}
	public void setProduct_price(Double product_price) {
		this.product_price = product_price;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	
	public String getProduct_img() {
		return product_img;
	}
	public void setProduct_img(String product_img) {
		this.product_img = product_img;
	}
	
	/*public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}*/
	@Override
	public String toString() {
		return product_name + ", х" + count + ", цена за единицу: " + product_price + "грн.";
	}
	
}
