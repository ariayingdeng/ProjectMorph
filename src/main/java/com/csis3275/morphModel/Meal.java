package com.csis3275.morphModel;

import java.util.ArrayList;
import java.util.Random;




public class Meal {

	private String mealName;
	private double calories, carbon, protein, fat;

	public String getMealName() {
		return mealName;
	}

	public void setMealName(String mealName) {
		this.mealName = mealName;
	}

	public double getCalories() {
		return calories;
	}

	public void setCalories(double calories) {
		this.calories = calories;
	}

	public double getCarbon() {
		return carbon;
	}

	public void setCarbon(double carbon) {
		this.carbon = carbon;
	}

	public double getProtein() {
		return protein;
	}

	public void setProtein(double protein) {
		this.protein = protein;
	}

	public double getFat() {
		return fat;
	}

	public void setFat(double fat) {
		this.fat = fat;
	}

	private enum BreakFast {
		Egg_Baked_In_Avocado("Egg Baked In Avocado", 205, 6.2, 7.6, 17.6),
		Mocha_Banana_Protein_Smoothie_Bowl("Mocha Banana Protein Smoothie Bowl", 272, 45, 20, 7.2),
		Breakfast_BLT_Salad("Breakfast BLT Salad", 292, 18, 17.5, 18),
		Savory_Breakfast_Quinoa_Salad_with_Eggs_and_Smoked_Salmon(
				"Savory Breakfast Quinoa Salad with Eggs and Smoked Salmon", 361, 29, 14, 22),
		Paleo_Breakfast_Fried_Rice("Paleo Breakfast Fried Rice", 154, 14.3, 7.2, 7.5),
		Five_Ingredient_Mexican_Stuffed_Sweet_Potatoes("5 Ingredient Mexican Stuffed Sweet Potatoes", 244, 28, 12, 10),
		Blueberry_Protein_Oatmeal("Blueberry Protein Oatmeal", 329, 50, 21, 11),
		Mini_Egg_Frittatas("Mini Egg Frittatas", 353, 17, 31, 17);

		private String name;
		private double calories;
		private double carbon;
		private double protein;
		private double fat;

		private BreakFast(String name, double calories, double carbon, double protein, double fat) {
			this.calories = calories;
			this.carbon = carbon;
			this.protein = protein;
			this.fat = fat;
		}

		public String getName() {
			return name;
		}

		public double[] getIngredient() {
			return new double[] { calories, carbon, protein, fat };
		}
	}

	private enum Dinner {
		Spicy_Shrimp_Caesar_Spinach_Salad("Spict Shrimp Caesar Spinach Salad", 248, 15.8, 25.6, 10.8),
		Skillet_Chicken_Fajitas("Skilled Chicken Fajitas", 270, 5, 36, 11),
		Apple_Cider_Chicken("Apple Cider Chicken", 286, 21, 30, 10),
		Warm_Spiced_Chickpea_Broccoli_Wrap("Warm Spiced Chickpea Brocolli Wrap", 541, 69, 25, 19),
		Tilapia_in_Parchment_With_Tomato_and_Broccoli_Over_Rice(
				"Tilapia in Parchment with Tomato and Brocoli over Rice", 514, 57, 32, 18),
		Shrimp_Tacos_With_Mango_Basil_Corn_and_Feta("Shrimp Tacos With Mango, Basil, Corn and Feta", 534, 59, 32, 20),
		Sheet_Pan_Chicken_Drumsticks_With_Warm_Farro_and_Apple_Salad(
				"Sheet Pan Chicken Drumsticks With Warm Farro and Apple Salad", 540, 63, 29, 20),
		MAPLE_MUSTARD_GRILLED_CHICKEN("Maple Mustard Grilled Chicken", 150, 7, 24, 3);

		private String name;
		private double calories;
		private double carbon;
		private double protein;
		private double fat;

		private Dinner(String name, double calories, double carbon, double protein, double fat) {
			this.calories = calories;
			this.carbon = carbon;
			this.protein = protein;
			this.fat = fat;
		}

		public String getName() {
			return name;
		}

		public double[] getIngredient() {
			return new double[] { calories, carbon, protein, fat };
		}
	}

	private enum HighProtein {
		Chicken_Breast("Chicken Breast", 165, 0, 31, 3.6), Chicken_Thigh("Chicken Thigh", 209, 0, 26, 12),
		Chicken_Drumstick("Chicken Drumstick", 172, 0, 28.3, 13), Beef("Beef", 250, 0, 26, 15),
		Lamb("Lamb", 294, 0, 25, 21), Duck_Meat("Duck Meat", 337, 0, 19, 28), Milk("Milk", 42, 5, 3.4, 1),
		Fish("Fish", 205, 0, 22, 12);

		private String name;
		private double calories;
		private double carbon;
		private double protein;
		private double fat;

		private HighProtein(String name, double calories, double carbon, double protein, double fat) {
			this.calories = calories;
			this.carbon = carbon;
			this.protein = protein;
			this.fat = fat;
		}

		public String getName() {
			return name;
		}

		public double[] getIngredient() {
			return new double[] { calories, carbon, protein, fat };
		}
	}

	private enum Fat {
		Oliver_Oil("Oliver Oil", 8.84, 0, 0, 100), Avocado_Oil("Avocado Oil", 8.84, 0, 0, 100),
		Grape_Oil("Grape Oil", 8.84, 0, 0, 100);

		private String name;
		private double calories;
		private double carbon;
		private double protein;
		private double fat;

		private Fat(String name, double calories, double carbon, double protein, double fat) {
			this.calories = calories;
			this.carbon = carbon;
			this.protein = protein;
			this.fat = fat;
		}

		public String getName() {
			return name;
		}

		public double[] getIngredient() {
			return new double[] { calories, carbon, protein, fat };
		}
	}

	private enum Vegetable {
		Broccoli("Broccoli", 31, 6, 2.5, 0.4), Brassica("Brassica", 42, 9, 3.4, 0.3),
		Spinach("Spinach", 23, 3.6, 2.9, 0.4), Cabbage("Cabbage", 25, 5.8, 1.3, 0.1),
		Carrot("Carrot", 41, 9.6, 0.9, 0.2), Asparagus("Asparagus", 24, 4.2, 2.6, 0.3),
		Beans("Bean", 31, 7.1, 1.8, 0.1), Brussels_Sprouts("Brussels Sprouts", 43, 9, 3.4, 0.3),
		Celery("Celery", 16, 3.7, 0.8, 0.1);

		private String name;
		private double calories;
		private double carbon;
		private double protein;
		private double fat;

		private Vegetable(String name, double calories, double carbon, double protein, double fat) {
			this.calories = calories;
			this.carbon = carbon;
			this.protein = protein;
			this.fat = fat;
		}

		public String getName() {
			return name;
		}

		public double[] getIngredient() {
			return new double[] { calories, carbon, protein, fat };
		}
	}

	public Meal generateDinner() {
		Random random = new Random();
		int dinnerNumber = random.nextInt(8);
		Meal myDinner = null;
		switch (dinnerNumber) {
		case 0:
			myDinner = getDinnerDetail(Dinner.Spicy_Shrimp_Caesar_Spinach_Salad);
			break;
		case 1:
			myDinner = getDinnerDetail(Dinner.Skillet_Chicken_Fajitas);
			break;
		case 2:
			myDinner = getDinnerDetail(Dinner.Apple_Cider_Chicken);
			break;
		case 3:
			myDinner = getDinnerDetail(Dinner.Warm_Spiced_Chickpea_Broccoli_Wrap);
			break;
		case 4:
			myDinner = getDinnerDetail(Dinner.Tilapia_in_Parchment_With_Tomato_and_Broccoli_Over_Rice);
			break;
		case 5:
			myDinner = getDinnerDetail(Dinner.Shrimp_Tacos_With_Mango_Basil_Corn_and_Feta);
			break;
		case 6:
			myDinner = getDinnerDetail(Dinner.Sheet_Pan_Chicken_Drumsticks_With_Warm_Farro_and_Apple_Salad);
			break;
		case 7:
			myDinner = getDinnerDetail(Dinner.MAPLE_MUSTARD_GRILLED_CHICKEN);
			break;
		
		}

		return myDinner;
	}

	private Meal getDinnerDetail(Dinner dinner) {
		Meal myDinner = new Meal();
		double[] detail = dinner.getIngredient();
		myDinner.setMealName(dinner.getName());
		myDinner.setCalories(detail[0]);
		myDinner.setCarbon(detail[1]);
		myDinner.setProtein(detail[2]);
		myDinner.setFat(detail[3]);

		return myDinner;
	}

	public Meal generateBreakfast() {
		Random random = new Random();
		int breakfastNumber = random.nextInt(8);
		Meal myBreakfast = null;

		switch (breakfastNumber) {
		case 0:
			myBreakfast = getBreakfastDetail(BreakFast.Egg_Baked_In_Avocado);
			break;
		case 1:
			myBreakfast = getBreakfastDetail(BreakFast.Mocha_Banana_Protein_Smoothie_Bowl);
			break;
		case 2:
			myBreakfast = getBreakfastDetail(BreakFast.Breakfast_BLT_Salad);
			break;
		case 3:
			myBreakfast = getBreakfastDetail(BreakFast.Savory_Breakfast_Quinoa_Salad_with_Eggs_and_Smoked_Salmon);
			break;
		case 4:
			myBreakfast = getBreakfastDetail(BreakFast.Paleo_Breakfast_Fried_Rice);
			break;
		case 5:
			myBreakfast = getBreakfastDetail(BreakFast.Five_Ingredient_Mexican_Stuffed_Sweet_Potatoes);
			break;
		case 6:
			myBreakfast = getBreakfastDetail(BreakFast.Blueberry_Protein_Oatmeal);
			break;
		case 7:
			myBreakfast = getBreakfastDetail(BreakFast.Mini_Egg_Frittatas);
			break;
		}

		return myBreakfast;

	}

	private Meal getBreakfastDetail(BreakFast breakFast) {
		Meal myBreakfast = new Meal();
		double[] detail = breakFast.getIngredient();
		myBreakfast.setMealName(breakFast.getName());
		myBreakfast.setCalories(detail[0]);
		myBreakfast.setCarbon(detail[1]);
		myBreakfast.setProtein(detail[2]);
		myBreakfast.setFat(detail[3]);

		return myBreakfast;
	}

	public ArrayList<Meal> generateLunch(double proteinTarget, double proteinAmount, double fatTarget, double fatAmount) {
		ArrayList<Meal> myLunch = new ArrayList<Meal>();
		myLunch.add(generateProtein());
		myLunch.add(generateVegetable());
		myLunch.add(generateOil());
				
		return myLunch;
	}
	
	private Meal generateProtein() {
		Meal meat = null;
		Random random = new Random();
		int meatNumber = random.nextInt(8);
		switch (meatNumber) {
		case 0:
			meat = getProteinDetail(HighProtein.Chicken_Breast);
			break;
		case 1:
			meat = getProteinDetail(HighProtein.Chicken_Thigh);
			break;
		case 2:
			meat = getProteinDetail(HighProtein.Chicken_Thigh);
			break;
		case 3:
			meat = getProteinDetail(HighProtein.Beef);
			break;
		case 4:
			meat = getProteinDetail(HighProtein.Lamb);
			break;
		case 5:
			meat = getProteinDetail(HighProtein.Duck_Meat);
			break;
		case 6:
			meat = getProteinDetail(HighProtein.Milk);
			break;
		case 7:
			meat = getProteinDetail(HighProtein.Fish);
			break;
		}
		
		return meat;
	}
	
	private Meal getProteinDetail(HighProtein protein) {
		Meal myProtein = new Meal();
		double[] detail = protein.getIngredient();
		myProtein.setMealName(protein.getName());
		myProtein.setCalories(detail[0]);
		myProtein.setCarbon(detail[1]);
		myProtein.setProtein(detail[2]);
		myProtein.setFat(detail[3]);
		
		return myProtein;
	}
	
	private Meal generateVegetable() {
		Meal myVege = null;
		Random random = new Random();
		int meatNumber = random.nextInt(9);
		switch (meatNumber) {
		case 0:
			myVege = getVegetableDetail(Vegetable.Broccoli);
			break;
		case 1:
			myVege = getVegetableDetail(Vegetable.Brassica);
			break;
		case 2:
			myVege = getVegetableDetail(Vegetable.Spinach);
			break;
		case 3:
			myVege = getVegetableDetail(Vegetable.Cabbage);
			break;
		case 4:
			myVege = getVegetableDetail(Vegetable.Carrot);
			break;
		case 5:
			myVege = getVegetableDetail(Vegetable.Asparagus);
			break;
		case 6:
			myVege = getVegetableDetail(Vegetable.Beans);
			break;
		case 7:
			myVege = getVegetableDetail(Vegetable.Brussels_Sprouts);
			break;
		case 8:
			myVege = getVegetableDetail(Vegetable.Celery);
			break;
		}
		
		return myVege;
	}
	
	private Meal getVegetableDetail(Vegetable vegetable) {
		Meal myVege = new Meal();
		double[] detail = vegetable.getIngredient();
		myVege.setMealName(vegetable.getName());
		myVege.setCalories(detail[0]);
		myVege.setCarbon(detail[1]);
		myVege.setProtein(detail[2]);
		myVege.setFat(detail[3]);
		
		return myVege;
	}
	
	private Meal generateOil() {
		Meal oil = null;
		Random random = new Random();
		int meatNumber = random.nextInt(8);
		switch (meatNumber) {
		case 0:
			oil = getOilDetail(Fat.Avocado_Oil);
			break;
		case 1:
			oil = getOilDetail(Fat.Oliver_Oil);
			break;
		case 2:
			oil = getOilDetail(Fat.Grape_Oil);
			break;
		
		}
		
		return oil;
	}
	
	private Meal getOilDetail(Fat fat) {
		Meal oil = new Meal();
		double[] detail = fat.getIngredient();
		oil.setMealName(fat.getName());
		oil.setCalories(detail[0]);
		oil.setCarbon(detail[1]);
		oil.setProtein(detail[2]);
		oil.setFat(detail[3]);
		
		return oil;
	}

}
