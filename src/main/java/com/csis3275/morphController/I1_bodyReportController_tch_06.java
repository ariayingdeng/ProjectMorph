package com.csis3275.morphController;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.csis3275.morphModel.BodyReport;
import com.csis3275.morphModel.CaloryReport;
import com.csis3275.morphModel.User;
import com.csis3275.morphRepository.UserRepository;




@Controller
public class I1_bodyReportController_tch_06 {
	
	@Autowired
	UserRepository userRepo;
	
	CaloryReport caloryReport;
	
	@RequestMapping("/")
	@GetMapping("/")
	public String startHomePage(HttpSession session, Model model) {		
		if (session.getAttribute("loggedIn") != null && (boolean) session.getAttribute("loggedIn")) {
			User loggedUser = userRepo.findById((int) session.getAttribute("userId"));
			model.addAttribute("loggedIn", loggedUser.getUsername());
		}
		return "morphHome";
	}
	
	
	@RequestMapping("/bodyAnalysisReport")
	@PostMapping("/bodyAnalysisReport")
	public String generateBodyReport(@ModelAttribute("bodyReport") BodyReport report, Model model, HttpSession session) {
		if (session.getAttribute("loggedIn") != null && (boolean) session.getAttribute("loggedIn")) {
			User loggedUser = userRepo.findById((int) session.getAttribute("userId"));
			model.addAttribute("loggedIn", loggedUser.getUsername());
			String name = loggedUser.getUsername();
			
			// Query the data from database
			
			
			int id = (int) session.getAttribute("userId");
			User thisUser = (User) userRepo.findById(id);	
			
			if (thisUser.getGender() == null) {
				model.addAttribute("analysis",new User());
				model.addAttribute("userName", thisUser.getUsername());
				return "bodyInfo";
			}
					
			
			double bodyFat;
			if (thisUser.getBodyFat() == 0)
				bodyFat = -1;
			else 
				bodyFat = thisUser.getBodyFat();
			
			// Create a report for user
			
			
			report = new BodyReport(thisUser.getUsername(), thisUser.getAge(), thisUser.getHeight(), thisUser.getWeight(), 
					thisUser.getGender(), bodyFat, thisUser.getActivity());
			

			
			model.addAttribute("bodyReport", report);
			fillTheSheet(model, report);
			

			
			
			return "bodyAnalysisReport";
		}
			return "userLogin";
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
