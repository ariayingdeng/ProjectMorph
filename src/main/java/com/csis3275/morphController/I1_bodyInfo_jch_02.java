package com.csis3275.morphController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.csis3275.morphDAO.UserDAOImpl;
import com.csis3275.morphModel.User;

@Controller
public class I1_bodyInfo_jch_02 {
	
	// Pre-autowired here, use only whenever needed. 
	@Autowired
	UserDAOImpl userDAOImpl;
	
	
	@RequestMapping("/")
	public String bodyAnalysis(@ModelAttribute("analysis")User user, Model model) {
		model.addAttribute("analysis",user);
		return "bodyAnalysis";
		
	}
	
	@PostMapping("/bodyAnalysis")
	public String showResult(@ModelAttribute("analysis")User user, Model model) {
		
		userDAOImpl.createUser(user);
		model.addAttribute("result", user.toString());
		return "bodyAnalysis";
	}
}
