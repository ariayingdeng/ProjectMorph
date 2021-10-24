package com.csis3275.morphModel;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;


@Entity
@Table(name="users")
public class User {

	@Id
	@GeneratedValue
	private int id;
	
	@Column(name="username", nullable=false, unique=true)
	private String username;
	
	@Column(name="password", nullable=false)
	private String password;
	
	@Column(name="birthdate", nullable=true)
	private String birthdate;
	
	@Column	(name="email", nullable=false, unique=true)
	private String email;
	
	@Transient
	private String confirmPw;
	
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
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getBirthdate() {
		return birthdate;
	}
	public void setBirthdate(String birthdate) {
		this.birthdate = birthdate;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getConfirmPw() {
		return confirmPw;
	}
	public void setConfirmPw(String confirmPw) {
		this.confirmPw = confirmPw;
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
