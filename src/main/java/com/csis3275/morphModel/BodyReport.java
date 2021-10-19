package com.csis3275.morphModel;


public class BodyReport {
	private String name;
	private String age;
	private String height;
	private String weight;
	private String bodyFat;
	private String gender;
	private double BMI;
	private int BMR;
	private int fat;
	private double heightNum;
	private double weightNum;
	private int TDEE;	
	private int exercise = 2;
	
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
	public BodyReport(String name, String age, String height, String weight, String gender, String bodyFat) {
		this.name = name;
		this.age = age;
		this.height = height;
		this.weight = weight;
		this.gender = gender;
		this.bodyFat = bodyFat;
		heightNum = Double.parseDouble(height);
		weightNum = Double.parseDouble(weight);
		try {
			fat = Integer.parseInt(bodyFat);
		} catch (Exception exception) {
			fat = -1;
		}
		generatePersonalCal();
		this.BMI = getBMI();
		getBMR();
		
		
	}
	
	
	
	/**
	 * use height and weight calculate BMI(Body Mass Index)
	 * @return the BMI of user
	 */
	public double getBMI() {		
		
		// BMI formula
		double BMI = weightNum / (heightNum * heightNum / 10000); 			
		
		return BMI;
	}
	
	
	/**
	 * use height, weight, and age to calculate BMR(Basal Metabolic Rate)
	 * @return the BMR of user
	 */
	public double getBMR() {
		double BMRNum;
		if (gender.equals("Male")) {
			BMRNum = 88.639 + (13.397 * weightNum) + (4.799 * heightNum) - 
					(5.677 * Integer.parseInt(age));
		} else {
			BMRNum = 447.593 + (9.247 * weightNum) + (3.098 * heightNum) -
					(4.330 * Integer.parseInt(age));
		}
		
		BMR = (int) BMRNum;
		return BMRNum;
	}	
	
	private void generatePersonalCal() {
		
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
