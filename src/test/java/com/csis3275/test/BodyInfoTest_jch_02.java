package com.csis3275.test;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Repository;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.csis3275.morphController.I1_bodyInfo_jch_02;
import com.csis3275.morphRepository.UserRepository;

@ExtendWith(SpringExtension.class)
@WebMvcTest(I1_bodyInfo_jch_02.class)
class BodyInfoTest_jch_02 {
	
	@Autowired
	private MockMvc mvc;
	
	@MockBean
	private UserRepository userRepository;
	
	@Test
	public void TestBodyInfoInputPage() throws Exception{
		mvc.perform(MockMvcRequestBuilders.get("/bodyInfoInput")
				.accept(MediaType.TEXT_HTML)
				.param("loggedIn", "true"))
		.andDo(print())
		.andExpect(status().isOk())
 		.andExpect(model().attributeExists("analysis"))
 		.andExpect(model().attribute("loggedIn", userRepository.existsByUsername("YingD")))
 		.andExpect(model().attribute("userName", userRepository.findByUsername("YingD")))
		.andExpect(MockMvcResultMatchers.view().name("userLogin"));
	}
	
}
