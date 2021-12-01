package com.csis3275.test;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.csis3275.morphController.WorkoutPlanController_yde_89;
import com.csis3275.morphRepository.UserRepository;

@ExtendWith(SpringExtension.class)
@WebMvcTest(WorkoutPlanController_yde_89.class)
class WorkoutPlanControllerTest_yde_89 {

	@Autowired
	private MockMvc mvc;
	
	@MockBean
    UserRepository userRepo;
	
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	
	/*
	 * Test the userLogin view is returned by the controller when user isn't login
	 */
	@Test
	public void testLoginPage() throws Exception {
		mvc.perform(MockMvcRequestBuilders
				.get("/workoutplan")
				.sessionAttr("loggedIn", false)
				.accept(MediaType.TEXT_HTML))
				.andDo(print())
				.andExpect(status().isOk())
				.andExpect(MockMvcResultMatchers.view().name("userLogin"));
	}
	

}
