package com.ecommerce.entities;


import javax.persistence.Entity;
import javax.persistence.Table;

import java.math.BigDecimal;
import java.util.Date;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;



@Entity
@Table (name = "eproduct")
public class Product {
	@Column (name = "ID")
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	Long id ;
	
	@Column (name = "name")
	String name;
	
	@Column (name = "price")
	BigDecimal price;
	
	@Column (name = "date_added", nullable = true)
	Date dateAdded;

	public Product() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Product(Long id, String name, BigDecimal price, Date datedAdded) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
		this.dateAdded = datedAdded;
	}
	


	public Product(String name, float price) {
		// TODO Auto-generated constructor stub
		super();
		//this.id = (long) 1000;
		this.name = name;
		this.price = new BigDecimal(Float.toString(price));
		this.dateAdded = new Date();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public Date getDateAdded() {
		return dateAdded;
	}

	public void setDateAdded(Date datedAdded) {
		this.dateAdded = datedAdded;
	}

	@Override
	public String toString() {
		return "Product [id=" + id + ", name=" + name + ", price=" + price + ", dateAdded=" + dateAdded + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(dateAdded, id, name, price);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Product other = (Product) obj;
		return Objects.equals(dateAdded, other.dateAdded) && Objects.equals(id, other.id)
				&& Objects.equals(name, other.name) && Objects.equals(price, other.price);
	}
	
	
	
	
	
	
	

}
