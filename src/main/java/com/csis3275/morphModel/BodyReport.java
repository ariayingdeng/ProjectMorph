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
		
		return BMRNum;
	}
	
	@Override
	public String toString() {
		BMI = getBMI();
		BMR = (int) getBMR();
		
		try {
			fat = Integer.parseInt(bodyFat);
		} catch (Exception exception) {
			fat = -1;
		}
		
		
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append("<div class='bodyReportContainer'> <p class='bodyReport'>");
		stringBuilder.append("Name: ").append(name);
		stringBuilder.append("<br>Age: ").append(age);
		stringBuilder.append("<br> Height: ").append(height);
		stringBuilder.append("<br>Weight: ").append(weight);
		stringBuilder.append(String.format("<br>BMI: %2f", BMI));
		stringBuilder.append(String.format("<br>BMR: %d", BMR));
		
		
		
		if (BMI < 18.5)
			stringBuilder.append(String.format("<br><br><b class='warning'>BMI %2f is too low, highly recommand"
					+ " to join the weight gainning course</b>", BMI));
		else if (BMI > 24 && BMI <= 27 && (fat > 25 || fat == -1))
			stringBuilder.append(String.format("<br><br><b class='warning'>BMI %2f is a little bit too high,"
					+ " please consider to join our exercise program and adjust the meal plan</b>", BMI));
		else if (BMI > 27 && BMI <= 30 && (fat > 25 || fat == -1))
			stringBuilder.append(String.format("<br><br><b class='warning'>BMI %2f is slightly overweight,"
					+ " please consider to join our exercise program and adjust the meal plan</b>", BMI));
		else if (BMI > 30 && (fat > 25 || fat == -1))
			stringBuilder.append(String.format("<br><br><b class='warning'>BMI %2f is overweight,"
					+ " highly recommand to join our exercise program and meal plan</b>", BMI));
		else if (BMI > 27 && fat > 17)
			stringBuilder.append(String.format("<br><br><b class='warning'>You have good amount of muscle, however,"
					+ " the body fat %d/% is a little bit high, plase consider to join our meal plan" + 
					" to change your shape!</b>", BMR));
		
		stringBuilder.append("</p> </div>");
		
		
		
		return stringBuilder.toString();
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
