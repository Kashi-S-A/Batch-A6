package com.ty.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Engine {

	@Id
	private int eid;
	private String fuel;
	private double cc;

	public Engine() {
	}

	public Engine(int eid, String fuel, double cc) {
		this.eid = eid;
		this.fuel = fuel;
		this.cc = cc;
	}

	public int getEid() {
		return eid;
	}

	public void setEid(int eid) {
		this.eid = eid;
	}

	public String getFuel() {
		return fuel;
	}

	public void setFuel(String fuel) {
		this.fuel = fuel;
	}

	public double getCc() {
		return cc;
	}

	public void setCc(double cc) {
		this.cc = cc;
	}

}
