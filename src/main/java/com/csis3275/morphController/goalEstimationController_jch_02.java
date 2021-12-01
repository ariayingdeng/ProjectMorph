package com.csis3275.morphController;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.csis3275.morphModel.GoalEstimation_jch_02;
import com.csis3275.morphModel.User;
import com.csis3275.morphRepository.UserRepository;

@Controller
public class goalEstimationController_jch_02 {
	
	@Autowired
	UserRepository userRepo;
	
	@RequestMapping("/estimationInfoInput")
	@PostMapping("/estimationInfoInput")
	public String goalEstimation(@ModelAttribute("estimation")GoalEstimation_jch_02 goalEstimation_jch_02, Model model, HttpSession session) {
		if (session.getAttribute("loggedIn") != null && (boolean) session.getAttribute("loggedIn")) {
			User loggedUser = userRepo.findById((int) session.getAttribute("userId"));
			model.addAttribute("loggedIn", loggedUser.getUsername());
			model.addAttribute("estimation",goalEstimation_jch_02);
			return "goalEstimation";
		}
		return "userLogin";
	}
	
	@PostMapping("/goalEstimation")
	public String goalEstimationResult(@ModelAttribute("estimation")GoalEstimation_jch_02 goalEstimation_jch_02, Model model, HttpSession session) {
		String name = (String) session.getAttribute("username");
		model.addAttribute("loggedIn", name);
		
		int id = (int) session.getAttribute("userId");
		User thisUser = (User) userRepo.findById(id);
		
		if(thisUser.getTDEE() == 0) {
			
			return "redirect:/bodyInfoInput";
		}
		else {
			goalEstimation_jch_02.setWeight(thisUser.getWeight());
			goalEstimation_jch_02.setTDEE(thisUser.getTDEE());
			model.addAttribute("userName", thisUser.getUsername());
			model.addAttribute("goalEstimateResult", goalEstimation_jch_02.toString());
			return "/goalEstimation";
		}
	}
}
