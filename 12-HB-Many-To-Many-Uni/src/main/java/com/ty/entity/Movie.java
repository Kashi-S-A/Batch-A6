package com.ty.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Movie {

	@Id
	private int mid;
	private String title;

	public Movie() {
	}

	public Movie(int mid, String title) {
		this.mid = mid;
		this.title = title;
	}

	public int getMid() {
		return mid;
	}

	public void setMid(int mid) {
		this.mid = mid;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

}
