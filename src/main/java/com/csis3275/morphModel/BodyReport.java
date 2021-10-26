package com.csis3275.morphModel;

import java.text.DecimalFormat;

public class BodyReport {
	private String name;
	private int age;
	private double height;
	private double weight;
	private double bodyFat;
	private String gender;
	private double BMI;
	private int BMR;
	private int fat;	
	private int TDEE;	
	private int exercise;
	
	/**
	 * Default constructor for empty one
	 */
	public BodyReport() {
		
	}
	
	/**
	 * Constructor assign the data fields
	 * @param name user's name
	 * @param age user's age
	 * @param height user's height
	 * @param weight user's weight
	 * @param bodyFat user's bodyFat
	 */
	public BodyReport(String name, int age, double height, double weight, String gender, double bodyFat, int exercise) {
		this.name = name;
		this.age = age;
		this.height = height;
		this.weight = weight;
		this.gender = gender;
		this.bodyFat = bodyFat;
		this.exercise = exercise;	
		
		gettBMR();		
		this.BMI = gettBMI();
		generatePersonalCal();
		
		
	}
	
	
	
	public double getBMI() {
		DecimalFormat dFormat = new DecimalFormat("#.##");
		BMI = Double.parseDouble(dFormat.format(BMI));
		return BMI;
	}

	public int getBMR() {
		return BMR;
	}

	/**
	 * use height and weight calculate BMI(Body Mass Index)
	 * @return the BMI of user
	 */
	public double gettBMI() {		
		
		// BMI formula
		double BMI = weight / (height * height / 10000); 			
		
		return BMI;
	}
	
	
	/**
	 * use height, weight, and age to calculate BMR(Basal Metabolic Rate)
	 * @return the BMR of user
	 */
	public double gettBMR() {
		double BMRNum;
		if (gender.equals("Male")) {
			BMRNum = 88.639 + (13.397 * weight) + (4.799 * weight) - 
					(5.677 * age);
		} else {
			BMRNum = 447.593 + (9.247 * weight) + (3.098 * weight) -
					(4.330 * age);
		}
		
		BMR = (int) BMRNum;
		return BMRNum;
	}	
	
	private void generatePersonalCal() {
//		System.out.println("generate personal cal");
		switch (exercise) {
			case 1:
				TDEE = (int) (BMR * 1.2);
				break;
			case 2:
				TDEE = (int) (BMR * 1.375);
				break;
			case 3:
				TDEE = (int) (BMR * 1.55);
				break;
			case 4:
				TDEE = (int) (BMR * 1.725);
				break;
			case 5:
				TDEE = (int) (BMR * 1.9);
				break;
		}
//		System.out.println("TDEE: " + TDEE);
		
		
	}
	
	
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
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
	
	public double getBodyFat() {
		return bodyFat;
	}
	public void setBodyFat(int bodyFat) {
		this.bodyFat = bodyFat;
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

	public int getFat() {
		return fat;
	}

	public void setFat(int fat) {
		this.fat = fat;
	}	

	public int getTDEE() {
		return TDEE;
	}

	public void setTDEE(int tDEE) {
		TDEE = tDEE;
	}

	public int getExercise() {
		return exercise;
	}

	public void setExercise(int exercise) {
		this.exercise = exercise;
	}

	public void setBMI(double bMI) {
		BMI = bMI;
	}

	public void setBMR(int bMR) {
		BMR = bMR;
	}
	
	
}
