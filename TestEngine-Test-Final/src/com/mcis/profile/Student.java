package com.mcis.profile;

import java.util.Date;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("stud")
public class Student extends Person {

	private String level;

	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}

	private float marks;

	public String getLevel() {
		return level;
	}

	public void setLevel(String level) {
		this.level = level;
	}

	public float getMarks() {
		return marks;
	}

	public void setMarks(float marks) {
		this.marks = marks;
	}

}
