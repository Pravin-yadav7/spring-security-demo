package com.divergentsl.springbootsecurity.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="student")
public class Student {
	
	@Id
	private int id;
	
	private String name;
	private String lastName;
	private String gender;
	private String course;
	private int fee;
	private int age;
	private long contactNo;
	
	public Student() {
		super();
	}


	public Student(int id, String name, String lastName, String gender, String course, int fee, int age,
			long contactNo) {
		super();
		this.id = id;
		this.name = name;
		this.lastName = lastName;
		this.gender = gender;
		this.course = course;
		this.fee = fee;
		this.age = age;
		this.contactNo = contactNo;
	}

	
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

	public String getCourse() {
		return course;
	}

	public void setCourse(String course) {
		this.course = course;
	}

	public int getFee() {
		return fee;
	}

	public void setFee(int fee) {
		this.fee = fee;
	}


	public String getLastName() {
		return lastName;
	}


	public void setLastName(String lastName) {
		this.lastName = lastName;
	}


	public String getGender() {
		return gender;
	}


	public void setGender(String gender) {
		this.gender = gender;
	}


	public int getAge() {
		return age;
	}


	public void setAge(int age) {
		this.age = age;
	}


	public long getContactNo() {
		return contactNo;
	}


	public void setContactNo(long contactNo) {
		this.contactNo = contactNo;
	}


	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", lastName=" + lastName + ", gender=" + gender + ", course="
				+ course + ", fee=" + fee + ", age=" + age + ", contactNo=" + contactNo + "]";
	}
	



}
