package com.csis3275.morphModel;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="users")
public class User {
	
	@Id
	@GeneratedValue
	private int id;
	
	@Column(name="username", nullable=false, unique=true)
	private String username;
	
	@Column(name="height", nullable=true)
	private double height;
	
	@Column(name="weight", nullable=true)
	private double weight;
	
	@Column(name="age", nullable=true)
	private int age;
	
	@Column(name="gender", nullable=true)
	private String gender;
	
	@Column(name="bodyFat", nullable=true)
	private double bodyFat;
	
	@Column(name="activity", nullable=true)
	private int activity;
	
	@Column(name="BMI", nullable=true)
	private double BMI;
	
	@Column(name="BMR", nullable=true)
	private int BMR;
	
	@Column(name="TDEE", nullable=true)
	private int TDEE;
	
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public double getHeight() {
		return height;
	}
	public void setHeight(double height) {
		this.height = height;
	}
	public double getWeight() {
		return weight;
	}
	public void setWeight(double weight) {
		this.weight = weight;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public double getBodyFat() {
		return bodyFat;
	}
	public void setBodyFat(double bodyFat) {
		this.bodyFat = bodyFat;
	}
	
	public int getActivity() {
		return activity;
	}
	public void setActivity(int activity) {
		this.activity = activity;
	}
	public double getBMI() {
		return BMI;
	}
	public void setBMI(double bMI) {
		BMI = bMI;
	}
	public int getBMR() {
		return BMR;
	}
	public void setBMR(int bMR) {
		BMR = bMR;
	}
	public int getTDEE() {
		return TDEE;
	}
	public void setTDEE(int tDEE) {
		TDEE = tDEE;
	}
	
	

	
}
