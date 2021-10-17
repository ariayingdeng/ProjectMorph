package com.csis3275.morphModel;

public class User {
	
	private double height;
	private double weight;
	private int age;
	private String gender;
	private double bodyFat;
	private int activity;
	
	
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
	@Override
	public String toString() {
		return "User [ height=" + height + ", weight=" + weight + ", age=" + age + ", gender=" + gender + ", bodyFat="
				+ bodyFat + ", activity=" + activity + " ]";
	}

	
}
