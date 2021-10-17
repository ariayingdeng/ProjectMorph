package com.csis3275.morphController;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.csis3275.morphModel.BodyReport;



@Controller
public class I1_bodyReportController_tch_06 {
//	
//	@RequestMapping("/")
//	public String startWebPageforDraft() {		
//		return "draft-tch-06";
//	}
	
	@RequestMapping("/")
	public String startWebPageforDraft() {		
		return "morphHome";
	}
	
	
	@PostMapping("/bodyReport")
	public String generateBodyReport(@ModelAttribute("bodyReport") BodyReport newReport, Model model) {
		
		// Query the data from database
		
		
		// Create a report for user
		String name = "James Chen";
		String age = "40";
		String weight = "75";
		String height = "170";
		String gender = "Male";
		String bodyFat = "18";
		
		newReport = new BodyReport(name, age, height, weight, gender, bodyFat);
		
		
		model.addAttribute("bodyReport", newReport.toString());
		
		return "draft-tch-06";
		
	}
}
