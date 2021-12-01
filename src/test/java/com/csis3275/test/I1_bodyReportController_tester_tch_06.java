package com.csis3275.test;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.HashMap;

import javax.websocket.Session;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.csis3275.morphController.I1_bodyReportController_tch_06;
import com.csis3275.morphModel.User;
import com.csis3275.morphRepository.UserRepository;





@ExtendWith(SpringExtension.class)
@WebMvcTest(I1_bodyReportController_tch_06.class)
class I1_bodyReportController_tester_tch_06 {
	
	
	@Autowired
	private MockMvc mvc;
	
	
	@MockBean
	private UserRepository userRepository;
	
	@Autowired
	private UserRepository myRepo;
	
	/*
	 * Test the appropriate view is return if no login information
	 */
	@Test
	public void testFrontPageWithNoLogin() throws Exception {
		mvc.perform(MockMvcRequestBuilders.post("/bodyAnalysisReport")
				.accept(MediaType.TEXT_HTML)
				.param("loggedIn", "false"))
		.andDo(print())
		.andExpect(status().isOk())
		.andExpect(model().attributeExists("bodyReport"))
		.andExpect(MockMvcResultMatchers.view().name("userLogin"));
	}
	
	@Test
	public void testFrontPageWithNoInfo() throws Exception {
		User tempUser = new User();
		tempUser.setUsername("James");
		tempUser.setId(1);
		myRepo.save(tempUser);
		System.out.println(myRepo.findById(1));
		assertNotNull(myRepo.findAll());
		
//		mvc.perform(MockMvcRequestBuilders.post("/bodyAnalysisReport")
//				.accept(MediaType.TEXT_HTML)				
//				.param("userId", "1")
//				.sessionAttr("userId", 1)
//				.sessionAttr("loggedIn", true)
//				
//				)
//		.andDo(print())
//		.andExpect(status().isOk())
//		.andExpect(model().attributeExists("bodyReport"))
//		.andExpect(model().attribute("loggedIn", userRepository.findByUsername("bnb")))		
//		.andExpect(MockMvcResultMatchers.view().name("bodyInfo"));
	}
	

}
