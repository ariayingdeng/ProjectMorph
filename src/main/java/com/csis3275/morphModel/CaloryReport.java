package com.csis3275.morphModel;

public class CaloryReport {
	private int dailyCalories;
	private int protein30;
	private int fat35;
	private int carb35;
	private int protein40;
	private int fat40;
	private int carb20;
	private int fat20;
	private int carb50;
	private int plan;
	
	public CaloryReport() {
		
	}
	
	public CaloryReport(int dailyCalories) {
		this.dailyCalories = dailyCalories;
		generateIngredient();
	}
		
	
	public CaloryReport(int dailyCalories, int plan) {
		this.dailyCalories = dailyCalories;
		this.plan = plan;
		generateIngredient();
	}
	
	private void generateIngredient() {
		if (plan == 1) {
			dailyCalories -= 500;
			setAmountOfIngredient(dailyCalories);			
		} else if (plan == 2) {
			dailyCalories += 500;
			setAmountOfIngredient(dailyCalories);
		} else {
			setAmountOfIngredient(dailyCalories);
		}
	}
	
	private void setAmountOfIngredient(int dailyCalories) {
		protein30 = (int) ((int) dailyCalories * 0.3 / 4);
		protein40 = (int) ((int) dailyCalories * 0.4 / 4);
		fat20 = (int) ((int) dailyCalories * 0.2 / 9);
		fat35 = (int) ((int) dailyCalories * 0.35 / 9);
		fat40 = (int) ((int) dailyCalories * 0.4 / 9);
		carb20 = (int) ((int) dailyCalories * 0.2 / 4);
		carb35 = (int) ((int) dailyCalories * 0.35 / 4);
		carb50 = (int) ((int) dailyCalories * 0.5 / 4);
	}

	public int getDailyCalories() {
		return dailyCalories;
	}

	public int getProtein30() {
		return protein30;
	}

	public int getFat35() {
		return fat35;
	}

	public int getCarb35() {
		return carb35;
	}

	public int getProtein40() {
		return protein40;
	}

	public int getFat40() {
		return fat40;
	}

	public int getCarb20() {
		return carb20;
	}

	public int getFat20() {
		return fat20;
	}

	public int getCarb50() {
		return carb50;
	}

	public int getPlan() {
		return plan;
	}
	
	
}
