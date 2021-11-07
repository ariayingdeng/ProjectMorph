package com.csis3275.morphController;

import java.util.ArrayList;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.csis3275.morphModel.Meal;
import com.csis3275.morphModel.User;
import com.csis3275.morphRepository.UserRepository;

@Controller
public class I2_generateMealPlanController_tch_06 {
	
	@Autowired
	UserRepository userRepo;
	
	Meal mealPlan;
	
	@PostMapping("/GenerateMealPlan")
	@RequestMapping("/GenerateMealPlan")
	public String generateMealPlan(HttpSession session, Model model) {
		if (session.getAttribute("loggedIn") != null && (boolean) session.getAttribute("loggedIn")) {
			User loggedUser = userRepo.findById((int) session.getAttribute("userId"));
			model.addAttribute("loggedIn", loggedUser.getUsername());
		} else {
			return "userLogin";
		}
		
		int breakfastServe = 1, dinnerServe = 1;
		
		User user = userRepo.findById((int) session.getAttribute("userId"));
		double TDEE = user.getTDEE();
		mealPlan = new Meal();
		Meal breakfast = mealPlan.generateBreakfast();
		Meal dinner = mealPlan.generateDinner();
		if (breakfast.getCalories() < 200) {
			breakfastServe++;
		} 
		
		if (dinner.getCalories() < 200) {
			dinnerServe = 4;
		} else if (dinner.getCalories() < 400) {
			dinnerServe = 2;
		}
		
		double currentCalories = dinner.getCalories() * dinnerServe + breakfastServe * breakfast.getCalories();
 		
		ArrayList<Meal> lunch = mealPlan.generateLunch(TDEE, TDEE, TDEE, TDEE);
		
		
		return "mealPlan";
	}
}
