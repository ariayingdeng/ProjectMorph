package com.csis3275.morphModel;

import java.util.Collections;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class WorkoutPlan_yde_89 {

	private Random random;
	private double totalCalories;
	private CaloriesCalculator_yde_89 caloriesCalculator;

	HashMap<Integer, LightExercise> lightExercises;
	HashMap<Integer, ModerateExercise> moderateExercises;
	HashMap<Integer, VigorousExercise> vigorousExercises;
	HashMap<String, Double> lightWorkoutPlan;
	HashMap<String, Double> moderateWorkoutPlan;
	HashMap<String, Double> vigorousWorkoutPlan;

	public WorkoutPlan_yde_89(double weight) {
		random = new Random();
		caloriesCalculator = new CaloriesCalculator_yde_89();
		caloriesCalculator.setDuration(30);
		caloriesCalculator.setWeight(weight);
		totalCalories = 0;
		lightExercises = new HashMap<>();
		moderateExercises = new HashMap<>();
		vigorousExercises = new HashMap<>();
		lightWorkoutPlan = new HashMap<>();
		moderateWorkoutPlan = new HashMap<>();
		vigorousWorkoutPlan = new HashMap<>();
	}

	public double getCalories() {
		return totalCalories;
	}

	public void setCalories(double calories) {
		this.totalCalories = calories;
	}

	public enum Day {
		SUNDAY, MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY
	}

	public enum LightExercise {
		DANCE("Slow Dance", 2.9), YOGA("Stretching yoga", 2.5), WALK("Walking, 2 mph", 2.5),
		HOUSEWORK("Housework, light", 2.5), FISHING("Fishing, standing", 2.5), GOLF("Golf", 3);

		private String exercise;
		private double met;

		private LightExercise(String exerciseName, double metValue) {
			exercise = exerciseName;
			met = metValue;
		}

		public double getMet() {
			return met;
		}

		public String getExercise() {
			return exercise;
		}

	}

	public enum ModerateExercise {
		BADMINTON("Badminton", 4.5), BICYCLING("Bicycling, leisurely", 3.5), BOWLING("Bowling", 3.5),
		DANCE("Dancing, modern, fast", 4.8), SWIMMING("Swimming, moderate pace", 4.5), TENNIS("Tennis", 5.0),
		SKATEBOARDING("Skateboarding", 5.0), TAICHI("Tai chi", 4.0), BASKETBALL("Basketball, shooting baskets", 4.5),
		JUMPING("Jumping on mini tramp", 4.5), TABLETENNIS("Table tennis", 4.0);

		private String exercise;
		private double met;

		private ModerateExercise(String exerciseName, double metValue) {
			exercise = exerciseName;
			met = metValue;
		}

		public double getMet() {
			return met;
		}

		public String getExercise() {
			return exercise;
		}
	}

	public enum VigorousExercise {
		WEIGHT("Weight lifting", 6), ABS("Abs exercises", 7), BRIDGES("Bridges (Butt lift)", 6), BURPEES("Burpees", 8),
		PUSHUPS("Push-Ups", 8), SITUPS("Sit-Ups", 8), SQUATS("Squats, heavy effort", 6.5),
		MOUNTAIN("Mountain climbers", 8);

		private String exercise;
		private double met;

		private VigorousExercise(String exerciseName, double metValue) {
			exercise = exerciseName;
			met = metValue;
		}

		public double getMet() {
			return met;
		}

		public String getExercise() {
			return exercise;
		}

	}

	public void loadLightExercises() {
		int position = 0;
		for (LightExercise exercise : LightExercise.values()) {
			lightExercises.put(position, exercise);
			position++;
		}
	}

	public void loadModerateExercises() {
		int position = 0;
		for (ModerateExercise exercise : ModerateExercise.values()) {
			moderateExercises.put(position, exercise);
			position++;
		}
	}

	public void loadVigorousExercises() {
		int position = 0;
		for (VigorousExercise exercise : VigorousExercise.values()) {
			vigorousExercises.put(position, exercise);
			position++;
		}
	}

	public List<String> getDays() {
		List<String> days = new ArrayList<>();
		ArrayList<Integer> randomNums = new ArrayList<>();
		int randomNum;
		while (randomNums.size() < 3) {
			randomNum = random.nextInt(7);
			if (!randomNums.contains(randomNum)) {
				randomNums.add(randomNum);
			}
		}
		Collections.sort(randomNums);
		for (Integer num : randomNums) {
			switch (num) {
			case 0:
				days.add(Day.SUNDAY.name());
				break;
			case 1:
				days.add(Day.MONDAY.name());
				break;
			case 2:
				days.add(Day.TUESDAY.name());
				break;
			case 3:
				days.add(Day.WEDNESDAY.name());
				break;
			case 4:
				days.add(Day.THURSDAY.name());
				break;
			case 5:
				days.add(Day.FRIDAY.name());
				break;
			case 6:
				days.add(Day.SATURDAY.name());
				break;
			}
		}
		return days;
	}

	public void generateWorkoutPlan() {
		int randomNum;
		double calories;
		loadLightExercises();
		loadModerateExercises();
		loadVigorousExercises();
		for (int n = 0; n < 3; n++) {
			randomNum = random.nextInt(lightExercises.size());
			LightExercise lExercise = lightExercises.get(randomNum);
			caloriesCalculator.setMet(lExercise.getMet());
			calories = caloriesCalculator.calculateCaloriesBurned();
			totalCalories += calories;
			lightWorkoutPlan.put(lExercise.getExercise(), calories);
			
			randomNum = random.nextInt(moderateExercises.size());
			ModerateExercise mExercise = moderateExercises.get(randomNum);
			caloriesCalculator.setMet(mExercise.getMet());
			calories = caloriesCalculator.calculateCaloriesBurned();
			totalCalories += calories;
			lightWorkoutPlan.put(mExercise.getExercise(), calories);
			
			randomNum = random.nextInt(vigorousExercises.size());
			VigorousExercise vExercise = vigorousExercises.get(randomNum);
			caloriesCalculator.setMet(vExercise.getMet());
			calories = caloriesCalculator.calculateCaloriesBurned();
			totalCalories += calories;
			lightWorkoutPlan.put(mExercise.getExercise(), calories);
		}

	}

}
