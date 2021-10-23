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
public class I1_signinController_yde_89 {
	
	@Autowired
	UserRepository userRepo;
	
	@RequestMapping("/loginPage")
	@PostMapping("/loginPage")
	public String showLoginPage(@ModelAttribute("newAccount") User user) {
		return "userLogin";
	}
	
	@PostMapping("/login")
	public String login(@ModelAttribute("userLogin") User signedUser, Model model, HttpSession session) {
		String username = signedUser.getUsername();
		String password = signedUser.getPassword();
		for (User user: userRepo.findAll()) {
			if (user.getUsername().equalsIgnoreCase(username) && user.getPassword().equals(password)) {
				session.setAttribute("userId", user.getId());
				return "morphHome";
			}
		}
		String errorMsg = "Incorrect username or password.";
		model.addAttribute("error", errorMsg);
		return "userLogin";
	}

	@RequestMapping("/registerPage")
	@PostMapping("/registerPage") 
	public String createNewUser(@ModelAttribute("newAccount") User user) {
		return "userRegister";
	}
	
	@PostMapping("/newUser")
	public String addUser(@ModelAttribute("newUser") User newUser, Model model) {
		if (!newUser.getPassword().equals(newUser.getConfirmPw())) {
			String wrongPw = "The passwords you entered don't match.";
			model.addAttribute("wrong", wrongPw);
			return "userRegister";
		}
		userRepo.save(newUser);
		return "userLogin";
	}
	

}
