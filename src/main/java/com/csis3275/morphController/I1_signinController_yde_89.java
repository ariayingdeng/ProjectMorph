package com.csis3275.morphController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.csis3275.morphDAO.UserDAOImpl;
import com.csis3275.morphModel.User;

@Controller
public class I1_signinController_yde_89 {
	
	@Autowired
	UserDAOImpl userDAOImpl;
	
	@RequestMapping("/")
	public String showLoginPage(Model model) {
		model.addAttribute("user", new User());
		return "userLogin";
	}
	
	@PostMapping("/login")
	public String login(@ModelAttribute("userLogin") User user, Model model) {
		String username = user.getUsername();
		String password = user.getPassword();
		if (userDAOImpl.correctUsernamePw(username, password)) {
//			model.addAttribute("username", username);
//			String welcome = "Welcome!";
//			model.addAttribute("welcome", welcome);
			return "userLogin";
		}
		else {
			String errorMsg = "Incorrect username or password";
			model.addAttribute("error", errorMsg);
			return "userLogin";
		}
	}

	@PostMapping("/create") 
	public String createNewUser(@ModelAttribute("newAccount") User user, Model model) {
		return "userRegister";
	}
	
	@PostMapping("/register")
	public String register(@ModelAttribute("newUser") User newUser, Model model) {
		userDAOImpl.createNewUser(newUser);
		return "userLogin";
	}
}
