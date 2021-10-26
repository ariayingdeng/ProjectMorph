package com.csis3275.morphController;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.csis3275.morphModel.BodyReport;
import com.csis3275.morphModel.CaloryReport;
import com.csis3275.morphModel.User;
import com.csis3275.morphRepository.UserRepository;


@Controller
public class I1_bodyInfo_jch_02 {
	
	@Autowired
	UserRepository userRepo;
	
	CaloryReport caloryReport;
	
	@RequestMapping("/bodyInfoInput")
	@PostMapping("/bodyInfoInput")
	public String bodyAnalysis(@ModelAttribute("analysis")User user, Model model, HttpSession session) {
		if (session.getAttribute("loggedIn") != null && (boolean) session.getAttribute("loggedIn")) {
			User loggedUser = userRepo.findById((int) session.getAttribute("userId"));
			model.addAttribute("loggedIn", loggedUser.getUsername());
			int id = (int) session.getAttribute("userId");
			User thisUser = (User) userRepo.findById(id);
			model.addAttribute("analysis",user);
			model.addAttribute("userName", thisUser.getUsername());
			return "bodyInfo";
		}
		return "userLogin";
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
		
		double bodyFat;
		if (thisUser.getBodyFat() == 0)
			bodyFat = -1;
		else 
			bodyFat = thisUser.getBodyFat();
		
		BodyReport report = new BodyReport(thisUser.getUsername(), thisUser.getAge(), thisUser.getHeight(), thisUser.getWeight(), 
				thisUser.getGender(), bodyFat, thisUser.getActivity());
		
		model.addAttribute("bodyReport", report);
		fillTheSheet(model, report);
		thisUser.setBMI(report.getBMI());
		thisUser.setBMR(report.getBMR());
		thisUser.setTDEE(report.getTDEE());

		return "bodyAnalysisReport";
	}
	
private void fillTheSheet(Model model, BodyReport report) {
		
		caloryReport = new CaloryReport(report.getTDEE());
		
		model.addAttribute("userName", report.getName());
		model.addAttribute("userAge", report.getAge());
		model.addAttribute("userHeight", report.getHeight());
		model.addAttribute("userWeight", report.getWeight());
		model.addAttribute("userBMI", report.getBMI());
		model.addAttribute("userBMR", report.getBMR());
		model.addAttribute("CaloriesPerDay", report.getTDEE());
		model.addAttribute("CaloriesPerWeek", report.getTDEE() * 7);
		model.addAttribute("moderateCarbonProtein", caloryReport.getProtein30());
		model.addAttribute("moderateCarbonFat", caloryReport.getFat35());
		model.addAttribute("moderateCarbonCarb", caloryReport.getCarb35());
		model.addAttribute("lowerCarbonProtein", caloryReport.getProtein40());
		model.addAttribute("lowerCarbonFat", caloryReport.getFat40());
		model.addAttribute("lowerCarbonCarb", caloryReport.getCarb20());
		model.addAttribute("higherCarbonProtein", caloryReport.getProtein30());
		model.addAttribute("higherCarbonFat", caloryReport.getFat20());
		model.addAttribute("higherCarbonCarb", caloryReport.getCarb50());		
		
	}
}
