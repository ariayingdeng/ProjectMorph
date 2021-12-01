package com.csis3275.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.csis3275.morphModel.CaloriesCalculator_yde_89;

class CaloriesCalculatorTest_yde_89 {
	
	CaloriesCalculator_yde_89 caloriesCalculatorTest = new CaloriesCalculator_yde_89();

	/*
	 * This test will test the duration getter and setter
	 */
	@Test
	void testDuration() {
		caloriesCalculatorTest.setDuration(30);
		assertEquals(30, caloriesCalculatorTest.getDuration());
	}
	
	/*
	 * This test will test the met getter and setter
	 */
	@Test
	void testMet() {
		caloriesCalculatorTest.setMet(4.5);
		assertEquals(4.5, caloriesCalculatorTest.getMet());
	}
	
	/*
	 * This test will test the weight getter and setter
	 */
	@Test
	void testWeight() {
		caloriesCalculatorTest.setWeight(78.8);
		assertEquals(78.8, caloriesCalculatorTest.getWeight());
	}
	
	/**
	 * This test will test the caloriesCalculatorTest() method
	 */
	@Test
	void testCalculateCaloriesBurned() {
		caloriesCalculatorTest.setDuration(40);
		caloriesCalculatorTest.setMet(6);
		caloriesCalculatorTest.setWeight(50.5);
		double calories = 40 * (6 * 3.5 * 50.5) / 200;
		assertEquals(calories, caloriesCalculatorTest.calculateCaloriesBurned());		
	}
	

}
