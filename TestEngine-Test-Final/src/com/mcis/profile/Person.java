package com.mcis.profile;

import java.util.Date;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
@Entity
@Table(name="personDetails")
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
@DiscriminatorValue("pers")
public class Person {
	@Id
	@GeneratedValue
	@Column(name="pid")
	private Integer id;
	@Column(name="name",nullable=false,length=30)
	private String name;
	@Enumerated(EnumType.STRING)
	@Column(nullable=false)
	private Gender gender;
	@Column(name="dob",nullable=false)
	@Temporal(TemporalType.DATE)
	private Date dateOfBirth;
	@Embedded
    private Address address;
	@Column(name="dept",nullable=false,length=20)
	private String department;
	/*public Person(Integer id, String name, Gender gender, Date dateOfBirth, Address address, String department) {
		super();
		this.id = id;
		this.name = name;
		this.gender = gender;
		this.dateOfBirth = dateOfBirth;
		this.address = address;
		this.department = department;
	}*/
	
	public Integer getId() {
		return id;
	}
	public Person() {
		super();
		// TODO Auto-generated constructor stub
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Gender getGender() {
		return gender;
	}
	public void setGender(Gender gender) {
		this.gender = gender;
	}
	public Date getDateOfBirth() {
		return dateOfBirth;
	}
	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	
	
}
