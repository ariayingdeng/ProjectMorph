package com.csis3275.test;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.forwardedUrl;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import javax.servlet.http.HttpSession;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.csis3275.morphController.goalEstimationController_jch_02;
import com.csis3275.morphModel.GoalEstimation_jch_02;
import com.csis3275.morphRepository.UserRepository;



@ExtendWith(SpringExtension.class)
@WebMvcTest(goalEstimationController_jch_02.class)
class GoalEstimationControllerTest_jch_02 {

	@Autowired
	private MockMvc mvc;
	
	@Autowired
	private HttpSession session;
	
	@MockBean
	private UserRepository userRepo;
	
	GoalEstimation_jch_02 goalEstimation_jch_02 = new GoalEstimation_jch_02();

	/**
	 * Testing the post of controller and expect appropriate result
	 */
	@Test
	public void TestEstimationResult() throws Exception {
		session.setAttribute("userId", userRepo.findByUsername("YingD").getId());
		mvc.perform(MockMvcRequestBuilders.post("/goalEstimation")
				.param("exerciseChoice", "3")
				.param("workoutHours", "5")
				.param("averageCaloriesIntakePerDay", "1800")
				.param("TargetWeightLost", "5")
				.contentType(MediaType.MULTIPART_FORM_DATA)
				.accept(MediaType.TEXT_HTML))
		.andDo(print())
		.andExpect(status().isOk())
		.andExpect(model().attributeExists("userName"))
		.andExpect(model().attribute("goalEstimateResult", ""));
		
	}

}
