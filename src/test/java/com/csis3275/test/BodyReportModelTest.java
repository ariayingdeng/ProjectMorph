package com.csis3275.test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Random;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

import com.csis3275.morphModel.BodyReport;

class BodyReportModelTest {

	BodyReport bodyReport;
	Random random;

	@BeforeEach
	void setUp() throws Exception {
		bodyReport = new BodyReport();
		random = new Random();
	}

	@RepeatedTest(5)
	@Test
	void testSetName() {
		char firstWord = (char) (random.nextInt(26) + 'A');
		int length = random.nextInt(15) + 1;
		String name = "";
		name += firstWord;
		for (int index = 0; index <= length; index++) {
			name += (char) (random.nextInt(26) + 'a');
		}
		bodyReport.setName(name);
		assertEquals(name, bodyReport.getName());
	}

	@RepeatedTest(5)
	@Test
	void testSetAge() {
		int age = random.nextInt(100) + 12;
		bodyReport.setAge(age);
		assertEquals(age, bodyReport.getAge());
	}

	@RepeatedTest(5)
	@Test
	void testSetHeight() {
		double height = random.nextDouble() * 50 + 150;
		bodyReport.setHeight(height);
		assertEquals(height, bodyReport.getHeight());
	}

	@RepeatedTest(5)
	@Test
	void testSetWeight() {
		double weight = random.nextDouble() * 60 + 40;
		bodyReport.setWeight(weight);
		assertEquals(weight, bodyReport.getWeight());
	}

	@RepeatedTest(5)
	@Test
	void testSetBodyFat() {
		int bodyFat = random.nextInt(25) + 5;
		bodyReport.setBodyFat(bodyFat);
		assertEquals(bodyFat, bodyReport.getBodyFat());
	}

	@RepeatedTest(5)
	@Test
	void testSetGender() {
		String male = "Male";
		String female = "Female";

		bodyReport.setGender(male);
		assertEquals(male, bodyReport.getGender());

		bodyReport.setGender(female);
		assertEquals(female, bodyReport.getGender());
	}

	@RepeatedTest(5)
	@Test
	void testCalculateBMR() {
		double weight = random.nextDouble() * 60 + 40;
		double height = random.nextDouble() * 50 + 150;
		String gender = "Male";
		int age = random.nextInt(100) + 12;
		bodyReport.setWeight(weight);
		bodyReport.setHeight(height);
		bodyReport.setGender(gender);
		bodyReport.setAge(age);
		double BMRNum;
		if (gender.equals("Male")) {
			BMRNum = 88.639 + (13.397 * weight) + (4.799 * weight) - (5.677 * age);
		} else {
			BMRNum = 447.593 + (9.247 * weight) + (3.098 * weight) - (4.330 * age);
		}

		int BMR = (int) BMRNum;
		bodyReport.gettBMR();
		assertEquals(BMR, bodyReport.getBMR());
	}

	@RepeatedTest(5)
	@Test
	void testCalculateBMI() {
		double weight = random.nextDouble() * 60 + 40;
		double height = random.nextDouble() * 50 + 150;

		bodyReport.setWeight(weight);
		bodyReport.setHeight(height);

		double BMI = weight / (height * height / 10000);

		assertEquals(BMI, bodyReport.gettBMI());
	}

	@RepeatedTest(5)
	@Test
	void testCalculateTDEE() {
		double weight = random.nextDouble() * 60 + 40;
		double height = random.nextDouble() * 50 + 150;
		String gender = "Male";
		int age = random.nextInt(100) + 12;
		int exercise = random.nextInt(5) + 1;
		int TDEE = 0;
		bodyReport = new BodyReport("Random User", age, height, weight, gender, 20, exercise);
		
		int BMR = bodyReport.getBMR();
		
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
		
		assertEquals(TDEE, bodyReport.getTDEE());
		

	}

}
