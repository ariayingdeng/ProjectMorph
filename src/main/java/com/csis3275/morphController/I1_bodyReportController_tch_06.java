package com.csis3275.morphController;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.csis3275.morphModel.BodyReport;
import com.csis3275.morphModel.CaloryReport;



@Controller
public class I1_bodyReportController_tch_06 {
//	
	
	CaloryReport caloryReport;
	
	
//	@RequestMapping("/")
//	public String startWebPageforDraft() {		
//		return "draft-tch-06";
//	}
	
	
	
//	
	@RequestMapping("/")
	public String startWebPageforDraft() {		
		return "morphHome";
	}
	
	
	@PostMapping("/bodyReport")
	public String generateBodyReport(@ModelAttribute("bodyReport") BodyReport report, Model model) {
		
		// Query the data from database
		
		
		// Create a report for user
		String name = "James Chen";
		String age = "40";
		String weight = "75";
		String height = "170";
		String gender = "Male";
		String bodyFat = "18";
		int exercise = 2;
		
		report = new BodyReport(name, age, height, weight, gender, bodyFat, exercise);
		

		
		model.addAttribute("bodyReport", report);
		fillTheSheet(model, report);
		
		
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
//		model.addAttribute(report)
//		model.addAttribute(report)
//		model.addAttribute(report)
//		model.addAttribute(report)
//		model.addAttribute(report)
//		model.addAttribute(report)
//		model.addAttribute(report)
//		model.addAttribute(report)
//		model.addAttribute(report)
//		model.addAttribute(report)
		
		
		
		
		
	}
}
