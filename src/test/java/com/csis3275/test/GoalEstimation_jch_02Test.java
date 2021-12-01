package com.csis3275.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.csis3275.morphModel.GoalEstimation_jch_02;

class GoalEstimation_jch_02Test {
	
	GoalEstimation_jch_02 myGoalEstimation = new GoalEstimation_jch_02();
	
	/**
	 * Testing Get/Set for TDEE
	 */
	@Test
	 void testTDEE() {
		myGoalEstimation.setTDEE(1550);
		assertEquals(1550, myGoalEstimation.getTDEE());
	}
	
	/**
	 * Testing Get/Set for Weight
	 */
	@Test
	 void testWeight() {
		myGoalEstimation.setWeight(90);
		assertEquals(90, myGoalEstimation.getWeight());
	}
	
	/**
	 * Testing Get/Set for ExerciseChoice
	 */
	@Test
	 void testExerciseChoice() {
		myGoalEstimation.setExerciseChoice(1);
		assertEquals(1, myGoalEstimation.getExerciseChoice());
	}
	
	/**
	 * Testing Get/Set for WorkOutHours
	 */
	@Test
	 void testWorkoutHours() {
		myGoalEstimation.setWorkoutHours(5);
		assertEquals(5, myGoalEstimation.getWorkoutHours());
	}
	
	/**
	 * Testing Get/Set for AverageCaloriesIntakePerDay
	 */
	@Test
	 void testAverageCaloriesIntakePerDay() {
		myGoalEstimation.setAverageCaloriesIntakePerDay(1800);
		assertEquals(1800, myGoalEstimation.getAverageCaloriesIntakePerDay());
	}
	
	/**
	 * Testing Get/Set for TargetWeightLost
	 */
	@Test
	 void testTargetWeightLost() {
		myGoalEstimation.setTargetWeightLost(5);
		assertEquals(5, myGoalEstimation.getTargetWeightLost());
	}
	
	/**
	 * Testing Boundary for MET
	 */
	@Test
	 void testMET() {
		myGoalEstimation.setExerciseChoice(1);
		myGoalEstimation.determineMET();
		assertEquals(3, myGoalEstimation.getMET());
		
		myGoalEstimation.setExerciseChoice(3);
		myGoalEstimation.determineMET();
		assertEquals(7, myGoalEstimation.getMET());
		
		myGoalEstimation.setExerciseChoice(4);
		myGoalEstimation.determineMET();
		assertEquals(7, myGoalEstimation.getMET());
	}
	
	/**
	 * Testing function of calculating Calories Burned From Workout
	 */
	@Test
	void testCalculateCaloriesBurnedFromWorkout() {
		myGoalEstimation.setExerciseChoice(1);
		myGoalEstimation.setWorkoutHours(5);
		myGoalEstimation.setWeight(90);
		assertEquals(1417.5, myGoalEstimation.calculateCaloriesBurnedFromWorkout());
	}
	
	/**
	 * Testing function of calculating Calories Burned Per Week
	 */
	@Test
	void testCalculateCaloriesBurnedPerWeek() {
		myGoalEstimation.setExerciseChoice(1);
		myGoalEstimation.setWorkoutHours(5);
		myGoalEstimation.setWeight(90);
		myGoalEstimation.setAverageCaloriesIntakePerDay(1500);
		myGoalEstimation.setTDEE(1550);
		assertEquals(1767.5, myGoalEstimation.calculateCaloriesBurnedPerWeek());
	}
	
	/**
	 * Testing function of calculating estimation of weeks needed 
	 * to lost 1kg
	 */
	@Test
	void testestimateWeeksPerKg() {
		myGoalEstimation.setExerciseChoice(1);
		myGoalEstimation.setWorkoutHours(5);
		myGoalEstimation.setWeight(90);
		myGoalEstimation.setAverageCaloriesIntakePerDay(1500);
		myGoalEstimation.setTDEE(1550);
		assertEquals(6, myGoalEstimation.estimateWeeksPerKg());
	}
	
	/**
	 * Testing function of calculating estimation of weeks needed 
	 * to lost to hit user's target weight lost
	 */
	@Test
	void testCalculateOverallWeeksNeeded() {
		myGoalEstimation.setExerciseChoice(1);
		myGoalEstimation.setWorkoutHours(5);
		myGoalEstimation.setWeight(90);
		myGoalEstimation.setAverageCaloriesIntakePerDay(1500);
		myGoalEstimation.setTDEE(1550);
		myGoalEstimation.setTargetWeightLost(5);
		assertEquals(30, myGoalEstimation.calculateOverallWeeksNeeded());
	}
	
	/**
	 * Testing toString so it will display appropriate result 
	 */
	@Test
	void testToString() {
		myGoalEstimation.setExerciseChoice(1);
		myGoalEstimation.setWorkoutHours(5);
		myGoalEstimation.setWeight(90);
		myGoalEstimation.setAverageCaloriesIntakePerDay(1500);
		myGoalEstimation.setTDEE(1550);
		myGoalEstimation.setTargetWeightLost(5);
		assertEquals("Target Weight Lost : 5 Kg <br>Calories Burned Per Week : 1767.5Kcal <br><br>"
				+ "<p class=\"esRes\"><strong>The Estimated Time To Achieve Your Goal Is : 30 Weeks.</strong></p>", myGoalEstimation.toString());
	}
}
