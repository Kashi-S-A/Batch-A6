package com.ty.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Product {

	@Id
	private int pid;
	private String name;
	private double price;
	private String description;

	@OneToMany(mappedBy = "product")
	private List<Review> reviews;

	public Product() {
	}

	public Product(int pid, String name, double price, String description) {
		this.pid = pid;
		this.name = name;
		this.price = price;
		this.description = description;
	}

	public int getPid() {
		return pid;
	}

	public void setPid(int pid) {
		this.pid = pid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}
