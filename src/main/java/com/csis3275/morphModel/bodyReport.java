package com.csis3275.morphModel;

public class bodyReport {
	private String name;
	private String age;
	private String height;
	private String weight;
	private String bodyFat;
	private String gender;
	
	
	/**
	 * Constructor assign the data fields
	 * @param name user's name
	 * @param age user's age
	 * @param height user's height
	 * @param weight user's weight
	 * @param bodyFat user's bodyFat
	 */
	public bodyReport(String name, String age, String height, String weight, String bodyFat) {
		this.name = name;
		this.age = age;
		this.height = height;
		this.weight = weight;
		this.bodyFat = bodyFat;
	}
	
	
	public String generateReport() {
		getBMI();
		getBMR();
		return null;
	}
	
	
	/**
	 * use height and weight calculate BMI(Body Mass Index)
	 * @return the BMI double data
	 */
	public double getBMI() {
		double heightNum = Double.parseDouble(height);
		double weightNum = Double.parseDouble(weight);
		
		// BMI formula
		double BMI = weightNum / (heightNum * heightNum); 			
		
		return BMI;
	}
	
	/**
	 * use height, weight, and age to calculate BMR(Basal Metabolic Rate)
	 * @return
	 */
	public double getBMR() {
		double BMRNum;
		if (gender.equals("male")) {
			BMRNum = 88.639 + (13.397 * Double.parseDouble(weight)) + (4.799 * Double.parseDouble(height)) - 
					(5.677 * Integer.parseInt(age));
		} else {
			BMRNum = 447.593 + (9.247 * Double.parseDouble(weight)) + (3.098 * Double.parseDouble(height)) -
					(4.330 * Integer.parseInt(age));
		}
		
		return BMRNum;
	}
	
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public String getHeight() {
		return height;
	}
	public void setHeight(String height) {
		this.height = height;
	}
	
	public String getWeight() {
		return weight;
	}
	public void setWeight(String weight) {
		this.weight = weight;
	}
	
	public String getBodyFat() {
		return bodyFat;
	}
	public void setBodyFat(String bodyFat) {
		this.bodyFat = bodyFat;
	}
	
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	
	public String getAge() {
		return age;
	}	
	public void setAge(String age) {
		this.age = age;
	}
	
	
}
