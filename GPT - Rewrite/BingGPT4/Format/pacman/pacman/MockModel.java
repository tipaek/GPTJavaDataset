package com.yeshj.pacman.jms.test;

import com.yeshj.pacman.annotation.Transmit;

public class MockModel {

	@Transmit(key = "id")
	private int id;

	@Transmit(key = "name")
	private String name;

	private double salary;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}
}
