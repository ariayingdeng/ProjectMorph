package com.csis3275.morphController;

import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.csis3275.morphModel.User;
import com.csis3275.morphModel.WorkoutPlan_yde_89;
import com.csis3275.morphRepository.UserRepository;

@Controller
public class WorkoutPlanController_yde_89 {
	
	@Autowired
	UserRepository userRepo;
	
	@RequestMapping("/workoutplan")
	@PostMapping("/workoutplan")
	public String generateWorkoutPlan(Model model, HttpSession session) {
		if (session.getAttribute("loggedIn") != null && (boolean) session.getAttribute("loggedIn")) {
			String name = (String) session.getAttribute("username");
			User loggedUser = userRepo.findByUsername(name);
			model.addAttribute("loggedIn", name);
			
			if (loggedUser.getTDEE() <= 0) {
				return "redirect:/bodyInfoInput";
			}
			else {
				double weight = loggedUser.getWeight();
				WorkoutPlan_yde_89 workoutPlan = new  WorkoutPlan_yde_89(weight);
				workoutPlan.generateWorkoutPlan();
				List<String> workoutDays = workoutPlan.getDays();
				model.addAttribute("day1", workoutDays.get(0));
				model.addAttribute("day2", workoutDays.get(1));
				model.addAttribute("day3", workoutDays.get(2));
				HashMap<String, Double> lightWorkout = workoutPlan.getLightWorkoutPlan();
				String exercise = "exercise";
				String calories = "calories";
				int position = 1;
				String exerciseAttribute;
				String caloriesAttribute;
				DecimalFormat df = new DecimalFormat("#.#");
				for (String key: lightWorkout.keySet()) {
					exerciseAttribute = exercise + position;
					caloriesAttribute = calories + position;
					model.addAttribute(exerciseAttribute, key);
					String cals = df.format(lightWorkout.get(key));
					model.addAttribute(caloriesAttribute, cals);
					position++;
				}
				HashMap<String, Double> moderateWorkout = workoutPlan.getModerateWorkoutPlan();
				for (String key: moderateWorkout.keySet()) {
					exerciseAttribute = exercise + position;
					caloriesAttribute = calories + position;
					model.addAttribute(exerciseAttribute, key);
					String cals = df.format(moderateWorkout.get(key));
					model.addAttribute(caloriesAttribute, cals);
					position++;
				}
				
				HashMap<String, Double> vigorousWorkout = workoutPlan.getVigorousWorkoutPlan();
				for (String key: vigorousWorkout.keySet()) {
					exerciseAttribute = exercise + position;
					caloriesAttribute = calories + position;
					model.addAttribute(exerciseAttribute, key);
					String cals = df.format(vigorousWorkout.get(key));
					model.addAttribute(caloriesAttribute, cals);
					position++;
				}
				
				return "workoutPlan";
			}
			
		}
		return "userLogin";
	}
	
	@PostMapping("/newPlan")
	public String generateNewPlan(Model model, HttpSession session) {
		return "redirect:/workoutplan";
	}
	
}
	
