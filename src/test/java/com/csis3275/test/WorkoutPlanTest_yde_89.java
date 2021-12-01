package com.csis3275.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.csis3275.morphModel.WorkoutPlan_yde_89;
import com.csis3275.morphModel.WorkoutPlan_yde_89.LightExercise;

class WorkoutPlanTest_yde_89 {

	WorkoutPlan_yde_89 workoutPlanTest = new WorkoutPlan_yde_89(50);
	
	/**
	 * Tests generateWorkoutPlan() which generates 3 workout plans for each type.
	 */
	@Test
	void testGenerateWorkoutPlan() {
		workoutPlanTest.generateWorkoutPlan();
		assertTrue((workoutPlanTest.getLightWorkoutPlan().size() == 3));
		assertTrue((workoutPlanTest.getModerateWorkoutPlan().size() == 3));
		assertTrue((workoutPlanTest.getVigorousWorkoutPlan().size() == 3));
	}
}
