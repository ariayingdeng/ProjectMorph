package com.csis3275.morphModel;

public class CaloriesCalculator_yde_89 {

	private double calories;
	private int duration;
	//activity MET: metabolic equivalent for task
	private double met;
	private double weight;
	
	public CaloriesCalculator_yde_89() {
		
	}
	
	public CaloriesCalculator_yde_89(int duration, double met, double weight) {
		this.duration = duration;
		this.met = met;
		this.weight = weight;
	}
	
	public double getCalories() {
		return calories;
	}
	public void setCalories(double calories) {
		this.calories = calories;
	}
	public int getDuration() {
		return duration;
	}
	public void setDuration(int duration) {
		this.duration = duration;
	}
	public double getMet() {
		return met;
	}
	public void setMet(double met) {
		this.met = met;
	}
	public double getWeight() {
		return weight;
	}
	public void setWeight(double weight) {
		this.weight = weight;
	}
	
	public double calculateCaloriesBurned() {
		// Total calories burned = Duration (in minutes)*(MET*3.5*weight in kg)/200
		calories = duration * (met * 3.5 * weight) / 200;
		return calories;
	}
	
}
