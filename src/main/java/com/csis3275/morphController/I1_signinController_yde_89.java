package com.csis3275.morphController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.csis3275.morphDao.UserRepository;
import com.csis3275.morphModel.User;

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
	public String login(@ModelAttribute("userLogin") User signedUser, Model model) {
		String username = signedUser.getUsername();
		String password = signedUser.getPassword();
		for (User user: userRepo.findAll()) {
			if (user.getUsername().equalsIgnoreCase(username) && user.getPassword().equals(password)) {
//				model.addAttribute("username", username);
//				String welcome = "Welcome!";
//				model.addAttribute("welcome", welcome);
				return "userLogin";
			}
		}
		String errorMsg = "Incorrect username or password.";
		model.addAttribute("error", errorMsg);
		return "userLogin";
	}

	@PostMapping("/register") 
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
