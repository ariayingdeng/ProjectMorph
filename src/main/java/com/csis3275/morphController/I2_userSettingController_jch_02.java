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
public class I2_userSettingController_jch_02 {
	
	@Autowired
	UserRepository userRepo;

	@RequestMapping("/userSetting")
	@PostMapping("/userSetting")
	public String userSetting(@ModelAttribute("setting")User user, Model model, HttpSession session) {
		if (session.getAttribute("loggedIn") != null && (boolean) session.getAttribute("loggedIn")) {
			User loggedUser = userRepo.findById((int) session.getAttribute("userId"));
			model.addAttribute("loggedIn", loggedUser.getUsername());
			int id = (int) session.getAttribute("userId");
			User thisUser = (User) userRepo.findById(id);
			model.addAttribute("setting",user);
			model.addAttribute("userName", thisUser.getUsername());
			return "/userSetting";
		}
		return "/userLogin";
	}
	
	@PostMapping("/userSettingInput")
	public String userSettingUpdate(@ModelAttribute("setting")User user, Model model, HttpSession session) {
		int id = (int) session.getAttribute("userId");
		User thisUser = (User) userRepo.findById(id);
		model.addAttribute("userName",thisUser.getUsername());
		
		boolean update = false;
		if(!user.getUsername().equals("")){
			thisUser.setUsername(user.getUsername());
			update=true;
		}

		if(!user.getPassword().equals("")){
			thisUser.setPassword(user.getPassword());
			update=true;
		}
		
		if(!user.getEmail().equals("")){
			thisUser.setEmail(user.getEmail());
			update=true;
		}

		if(update) {
			String success = "Hi " + thisUser.getUsername() + " , You have successfully updated your Information !";
			model.addAttribute("updateSuccess", success);
		}
		
		return "/userSetting";
	}
}
