package com.ty.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Review {

	@Id
	private int rid;
	private String msg;

	@ManyToOne
	@JoinColumn(name = "prod_id")
	private Product product;

	public Review() {
	}

	public Review(int rid, String msg) {
		this.rid = rid;
		this.msg = msg;
	}

	public int getRid() {
		return rid;
	}

	public void setRid(int rid) {
		this.rid = rid;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

}
