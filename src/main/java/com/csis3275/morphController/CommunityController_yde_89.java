package com.csis3275.morphController;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.csis3275.morphModel.Post_yde_89;
import com.csis3275.morphRepository.PostsRepository;
import com.csis3275.morphRepository.UserRepository;

@Controller
public class CommunityController_yde_89 {
	
	@Autowired
	UserRepository userRepo;
	
	@Autowired
	PostsRepository postsRepo;
	
	@RequestMapping("/community")
	@PostMapping("/community")
	public String getCommunityForm(Model model, HttpSession session) {
		if (session.getAttribute("loggedIn") != null && (boolean) session.getAttribute("loggedIn")) {
			String name = (String) session.getAttribute("username");
			model.addAttribute("loggedIn", name);
			model.addAttribute("loggeduser", name);
			System.out.println(name);
			
			displayAllPosts(model);
			return "community";
		}
		return "userLogin";
	}
	
	@RequestMapping("/community/newpost")
	@PostMapping("/community/newpost")
	public String newPost(@ModelAttribute("newpost") Post_yde_89 newpost, Model model, HttpSession session) {
		if (session.getAttribute("loggedIn") != null && (boolean) session.getAttribute("loggedIn")) {
			String name = (String) session.getAttribute("username");
			model.addAttribute("loggedIn", name);
			newpost.setUser((String) session.getAttribute("username"));
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d MMM yyyy");
			LocalDate date = LocalDate.now();
			String dateString = formatter.format(date);
			newpost.setDate(dateString);
			
			postsRepo.save(newpost);
			return "redirect:/community";
		}
		return "userLogin";
	}
	
	@GetMapping("/community/like/")
	public String likesPost(@RequestParam(required = true) int id, Model model, HttpSession session) {
		if (session.getAttribute("loggedIn") != null && (boolean) session.getAttribute("loggedIn")) {
			Post_yde_89 post = postsRepo.findById(id);
			int likes = post.getLikes();
			likes++;
			post.setLikes(likes);
			return "redirect:/community";
		}
		return "userLogin";
	}
	
	@GetMapping("/community/delete/")
	public String deletePost(@RequestParam(required = true) int id, Model model, HttpSession session) {
		if (session.getAttribute("loggedIn") != null && (boolean) session.getAttribute("loggedIn")) {
			postsRepo.deleteById(id);
			return "redirect:/community";
		}
		return "userLogin";
	}
	
	private void displayAllPosts(Model model) {
		ArrayList<Post_yde_89> allPosts = (ArrayList<Post_yde_89>) postsRepo.findAll(orderByIdDesc());
		model.addAttribute("allPosts", allPosts);
	}
	
	private Sort orderByIdDesc() {
		 return Sort.by(Sort.Direction.DESC, "postId");
	}

}
