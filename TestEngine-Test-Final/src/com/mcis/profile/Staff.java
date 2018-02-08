package com.mcis.profile;

import java.util.Date;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("staff")
public class Staff extends Person {

	private String designation;

	public Staff() {
		super();
		// TODO Auto-generated constructor stub
	}

	private float salary;

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public float getSalary() {
		return salary;
	}

	public void setSalary(float salary) {
		this.salary = salary;
	}

}
