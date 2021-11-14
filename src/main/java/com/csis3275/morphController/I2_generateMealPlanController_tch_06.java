package com.csis3275.morphController;

import java.text.DecimalFormat;
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
		
		double remainingCalories = TDEE - currentCalories;
		
		
		DecimalFormat df = new DecimalFormat("#.#");
		ArrayList<Meal> lunch = mealPlan.generateLunch();
		double meatServe = 1, vegeServe = 1, oilServe = 0.1;
		double meatCal = lunch.get(0).getCalories();
		double vegeCal = lunch.get(1).getCalories();
		double oilCal = lunch.get(2).getCalories();
		meatServe = Double.parseDouble(df.format(remainingCalories * 0.6 / meatCal));
		vegeServe = Double.parseDouble(df.format(remainingCalories * 0.2 / vegeCal));
		oilServe = Double.parseDouble(df.format(remainingCalories * 0.2 / oilCal));
		double[] lunchServes = {meatServe, vegeServe, oilServe};
		String[] lunchServesStrings = {meatServe * 100 + " g, ", vegeServe * 100 + " g, ", oilServe + " g"};
		
		setBreakfast(model, breakfast, breakfastServe);
		
		setLunch(model, lunch, lunchServes, lunchServesStrings);
		
		setDinner(model, dinner, dinnerServe);
		return "mealPlan";
	}
	
	private void setBreakfast(Model model, Meal meal, int serve) {
		model.addAttribute("breakfastName", meal.getMealName());
		model.addAttribute("serveBreakfast", serve);
		model.addAttribute("breakfastCarbon", meal.getCarbon() * serve);
		model.addAttribute("breakfastProtein", meal.getProtein() * serve);
		model.addAttribute("breakfastFat", meal.getFat() * serve);
		model.addAttribute("breakfastCal", meal.getCalories() * serve);
		model.addAttribute("breakfastWeight", (meal.getCarbon() * 8 + meal.getProtein() * 5 + meal.getFat() * 2) * serve);
	}
	
	private void setLunch(Model model, ArrayList<Meal> lunch, double[] serves, String[] lunchServesStrings) {
		DecimalFormat df = new DecimalFormat("#.#");
		model.addAttribute("lunchName", lunch.get(0).getMealName() + ", " + lunch.get(1).getMealName() + ", " + lunch.get(2).getMealName() );
		model.addAttribute("serveLunch", lunchServesStrings[0] + lunchServesStrings[1] + lunchServesStrings[2]);
		model.addAttribute("lunchCarbon", df.format(lunch.get(0).getCarbon() * serves[0]+ lunch.get(1).getCarbon() * serves[1] + lunch.get(2).getCarbon() * serves[2]));
		model.addAttribute("lunchProtein", df.format(lunch.get(0).getProtein() * serves[0] + lunch.get(1).getProtein() * serves[1] + lunch.get(2).getProtein() * serves[2]));
		model.addAttribute("lunchFat", df.format(lunch.get(0).getFat() * serves[0] + lunch.get(1).getFat() * serves[1] + lunch.get(2).getFat() * serves[2]));
		model.addAttribute("lunchCal", df.format(lunch.get(0).getCalories() * serves[0] + lunch.get(1).getCalories() * serves[1] + lunch.get(2).getCalories() * serves[2]));
	}
	
	private void setDinner(Model model, Meal meal, int serve) {
		model.addAttribute("dinnerName", meal.getMealName());
		model.addAttribute("serveDinner", serve);
		model.addAttribute("dinneCarbon", meal.getCarbon() * serve);
		model.addAttribute("dinneProtein", meal.getProtein() * serve);
		model.addAttribute("dinneFat", meal.getFat() * serve);
		model.addAttribute("dinneCal", meal.getCalories() * serve);
		model.addAttribute("dinnerWeight", (meal.getCarbon() * 8 + meal.getProtein() * 5 + meal.getFat() * 2) * serve);
	}
	
	
}
