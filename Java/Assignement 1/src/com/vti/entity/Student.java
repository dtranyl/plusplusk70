package com.vti.entity;

import java.time.LocalDate;

public class Student {
	private int id;
	private String name;
	private LocalDate birthdayDate;
	private String email;
	private String classStudy;
	private LocalDate createDate;

	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Student(int id, String name, LocalDate birthdayDate, String email, String classStudy, LocalDate createDate) {
		super();
		this.id = id;
		this.name = name;
		this.birthdayDate = birthdayDate;
		this.email = email;
		this.classStudy = classStudy;
		this.createDate = createDate;
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

	public LocalDate getBirthdayDate() {
		return birthdayDate;
	}

	public void setBirthdayDate(LocalDate birthdayDate) {
		this.birthdayDate = birthdayDate;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getClassStudy() {
		return classStudy;
	}

	public void setClassStudy(String classStudy) {
		this.classStudy = classStudy;
	}

	public LocalDate getCreateDate() {
		return createDate;
	}

	public void setCreateDate(LocalDate createDate) {
		this.createDate = createDate;
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", birthdayDate=" + birthdayDate + ", email=" + email
				+ ", classStudy=" + classStudy + ", createDate=" + createDate + "]";
	}

}
