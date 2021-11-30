package com.csis3275.morphModel;

public class GoalEstimation_jch_02 {
	private int TDEE ; 
	private double weight;
	private int exerciseChoice;
	private int MET;
	private double workoutHours;
	private double averageCaloriesIntakePerDay;
	private int TargetWeightLost;  
	
	public int getTDEE() {
		return TDEE;
	}
	public void setTDEE(int tDEE) {
		TDEE = tDEE;
	}
	public double getWeight() {
		return weight;
	}
	public void setWeight(double weight) {
		this.weight = weight;
	}
	
	public int getExerciseChoice() {
		return exerciseChoice;
	}
	public void setExerciseChoice(int exerciseChoice) {
		this.exerciseChoice = exerciseChoice;
	}
	
	public int getWorkoutHours() {
		return (int) this.workoutHours;
	}
	public void setWorkoutHours(double workoutHours) {
		this.workoutHours = workoutHours;
	}
	public double getAverageCaloriesIntakePerDay() {
		return averageCaloriesIntakePerDay;
	}
	public void setAverageCaloriesIntakePerDay(double averageCaloriesIntakePerDay) {
		this.averageCaloriesIntakePerDay = averageCaloriesIntakePerDay;
	}
	
	public int getTargetWeightLost() {
		return TargetWeightLost;
	}
	public void setTargetWeightLost(int targetWeightLost) {
		TargetWeightLost = targetWeightLost;
	}
	public int getMET() {
		return MET;
	}
	public void determineMET() {
		if(getExerciseChoice()==1) {
			this.MET = 3;
		}
		else if(getExerciseChoice()==2) {
			this.MET = 5;
		}
		else if(getExerciseChoice()==3) {
			this.MET = 7;
		}
	}
	public double calculateCaloriesBurnedFromWorkout() {
		determineMET();
		CaloriesCalculator_yde_89 calculator = new CaloriesCalculator_yde_89((getWorkoutHours()*60),getMET(),getWeight());
		double CaloriesBurnedFromWorkOut = calculator.calculateCaloriesBurned();
		return CaloriesBurnedFromWorkOut;
	}
	
	public double calculateCaloriesBurnedPerWeek() {
		double CaloriesBurnedPerWeek = ((getTDEE()*7)+calculateCaloriesBurnedFromWorkout()) - (getAverageCaloriesIntakePerDay()*7);
		return CaloriesBurnedPerWeek;
	}
	
	public int estimateWeeksPerKg() {
		int estimateWeeks = (int) ((9000/calculateCaloriesBurnedPerWeek())+1);
		return estimateWeeks;
	}
	
	public int calculateOverallWeeksNeeded() {
		int weeksNeeded = estimateWeeksPerKg()*getTargetWeightLost();
		return weeksNeeded;
	}
	
	public String toString() {
		return "Target Weight Lost : " + getTargetWeightLost() +" Kg <br>Calories Burned Per Week : "+calculateCaloriesBurnedPerWeek()
		+ "Kcal <br><br><p class=\"esRes\"><strong>The Estimated Time To Achieve Your Goal Is : " + calculateOverallWeeksNeeded() + " Weeks.</strong></p>";
	}
}
