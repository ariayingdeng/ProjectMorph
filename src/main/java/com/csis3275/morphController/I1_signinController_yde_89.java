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
	
	@RequestMapping("/")
	public String showLoginPage(Model model) {
		model.addAttribute("user", new User());
		return "userLogin";
	}
	
	@PostMapping("/login")
	public String login(@ModelAttribute("userLogin") User signedUser, Model model, HttpSession session) {
		String username = signedUser.getUsername();
		String password = signedUser.getPassword();
		for (User user: userRepo.findAll()) {
			if (user.getUsername().equalsIgnoreCase(username) && user.getPassword().equals(password)) {
//				String welcomeMsg = "Welcome, " + username;
//				model.addAttribute("welcome", welcomeMsg);
//				return "morphHome";
				session.setAttribute("userId", user.getId());
				return "userLogin";
			}
		}
		String errorMsg = "Incorrect username or password.";
		model.addAttribute("error", errorMsg);
		return "userLogin";
	}

	@RequestMapping("/register") 
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
