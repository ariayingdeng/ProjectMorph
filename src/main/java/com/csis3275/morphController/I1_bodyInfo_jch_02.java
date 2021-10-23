package com.csis3275.morphController;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.csis3275.morphModel.User;
import com.csis3275.morphRepository.UserRepository;


@Controller
public class I1_bodyInfo_jch_02 {
	
	@Autowired
	UserRepository userRepo;
	
	@RequestMapping("/")
	public String bodyAnalysis(@ModelAttribute("analysis")User user, Model model, HttpSession session) {
			int id = (int) session.getAttribute("userId");
			User thisUser = (User) userRepo.findById(id);
			model.addAttribute("analysis",user);
			model.addAttribute("userName", thisUser.getUsername());
			return "bodyAnalysis";
	}
	
	@PostMapping("/bodyAnalysis")
	public String showResult(@ModelAttribute("analysis")User user, Model model, HttpSession session) {
		int id = (int) session.getAttribute("userId");
		User thisUser = (User) userRepo.findById(id);
		thisUser.setHeight(user.getHeight());
		thisUser.setWeight(user.getWeight());
		thisUser.setAge(user.getAge());
		thisUser.setGender(user.getGender());
		thisUser.setBodyFat(user.getBodyFat());
		thisUser.setActivity(user.getActivity());

		return "bodyAnalysis";
	}
}
