package com.dlvr.model.entity;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity; 
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

@Entity
@javax.persistence.Table(name="users")
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;    
	public String login;
    public String password;
    public String telephone;
    public String address;
    public String role;
    public Integer isfree;
    
  /*  @OneToMany(cascade = CascadeType.ALL, mappedBy = "user")
    public List<Basket> baskets;
    */
    public User() {
      
    }
	  public Long getId() {
	    return id;
	  }
	  public String getLogin() {
	    return login;
	  }
	  public void setLogin(String login) {
	    this.login = login;
	  }
	  public String getPassword() {
	    return password;
	  }
	  public void setPassword(String password) {
	    this.password = password;
	  }
	  
	  public String getTelephone() {
		return telephone;
	  }
	  public void setTelephone(String telephone) {
			this.telephone = telephone;
	  }
	  public String getAddress() {
			return address;
	  }
	  public void setAddress(String address) {
		  this.address = address;
	  }
	  public String getRole() {
		  return role;
	  }
	  public void setRole(String role) {
		  this.role = role;
	  }
	  
	  public void setId(Long id) {
		this.id = id;
	  }
	public Integer getIsfree() {
		return isfree;
	}
	public void setIsfree(Integer isfree) {
		this.isfree = isfree;
	}
	
	/*public List<Basket> getBaskets() {
		return baskets;
	}
	public void setBaskets(List<Basket> baskets) {
		this.baskets = baskets;
	}*/
	@Override
	public String toString() {
		return "User [login=" + login + ", telephone=" + telephone
				+ ", address=" + address + "]";
	}
	  
}
