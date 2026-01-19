package com.ty.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Actor {

	@Id
	private int aid;
	private String name;
	private int age;

	@ManyToMany
	private List<Movie> movies;

	public Actor() {
	}

	public Actor(int aid, String name, int age) {
		this.aid = aid;
		this.name = name;
		this.age = age;
	}

	public int getAid() {
		return aid;
	}

	public void setAid(int aid) {
		this.aid = aid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public List<Movie> getMovies() {
		return movies;
	}

	public void setMovies(List<Movie> movies) {
		this.movies = movies;
	}

}
