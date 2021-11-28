package com.csis3275.morphController;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayDeque;
import java.util.Queue;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.csis3275.morphModel.DateSystem;
import com.csis3275.morphModel.User;
import com.csis3275.morphRepository.UserRepository;

@Controller
public class I3_checkInSystemController_tch_06 {

	@Autowired
	UserRepository userRepo;

	DateSystem dateSystem;

	Queue<Day> myDateQueue;

	int year, month, date;

	@PostMapping("checkin")
	@RequestMapping("/checkin")
	public String checkInPage(@ModelAttribute("Day") Day day, Model model, HttpSession session) {

		if (session.getAttribute("loggedIn") != null && (boolean) session.getAttribute("loggedIn")) {
			User loggedUser = userRepo.findById((int) session.getAttribute("userId"));
			model.addAttribute("loggedIn", loggedUser.getUsername());
		} else {
			return "userLogin";
		}

		String[] currentDate = getCurrentTime().split("/");
		year = Integer.parseInt(currentDate[0]);
		month = Integer.parseInt(currentDate[1]);
		date = Integer.parseInt(currentDate[2]);
		dateSystem = new DateSystem(date, month, year);
		fillEmptry(year, month, date);

		fillQueue(year, month);

		model.addAttribute("dates", myDateQueue);
		model.addAttribute("month", year + "/ " + getMonthString());
		model.addAttribute("selected", date);
		passToSession(session, year, month, date);
		return "checkInSystem";
	}

	@PostMapping("/checkingByDate")
	public String checkingPage(@ModelAttribute("Day") Day day, Model model, HttpSession session) {
		
		
		if (session.getAttribute("loggedIn") != null && (boolean) session.getAttribute("loggedIn")) {
			User loggedUser = userRepo.findById((int) session.getAttribute("userId"));
			model.addAttribute("loggedIn", loggedUser.getUsername());
		} else {
			return "userLogin";
		}
		year = (int) session.getAttribute("Year");
		month = (int) session.getAttribute("Month");
		date = day.getDay();

		dateSystem = new DateSystem(date, month, year);
		fillEmptry(year, month, date);

		fillQueue(year, month);

		model.addAttribute("dates", myDateQueue);
		model.addAttribute("month", year + "/ " + getMonthString());
		model.addAttribute("selected", date);
		passToSession(session, year, month, date);

		System.out.println(year + "/ " + month + "/ " + date);

		return "checkInSystem";
	}

	@PostMapping("/ToPrevious")
	public String previousMonthPage(@ModelAttribute("Day") Day day, Model model, HttpSession session) {

		
		if (session.getAttribute("loggedIn") != null && (boolean) session.getAttribute("loggedIn")) {
			User loggedUser = userRepo.findById((int) session.getAttribute("userId"));
			model.addAttribute("loggedIn", loggedUser.getUsername());
		} else {
			return "userLogin";
		}
		year = (int) session.getAttribute("Year");
		month = (int) session.getAttribute("Month") - 1;
		date = (int) session.getAttribute("Date");
		if (month == 0) {
			month += 12;
			year--;
		}
		dateSystem = new DateSystem(date, month, year);
		fillEmptry(year, month, date);
		fillQueue(year, month);

		model.addAttribute("dates", myDateQueue);
		model.addAttribute("month", year + "/ " + getMonthString());
		model.addAttribute("selected", date);
		passToSession(session, year, month, date);

		System.out.println(year + "/ " + month + "/ " + date);

		return "checkInSystem";

	}

	@PostMapping("/ToNext")
	public String nextMonthPage(@ModelAttribute("Day") Day day, Model model, HttpSession session) {

		
		if (session.getAttribute("loggedIn") != null && (boolean) session.getAttribute("loggedIn")) {
			User loggedUser = userRepo.findById((int) session.getAttribute("userId"));
			model.addAttribute("loggedIn", loggedUser.getUsername());
		} else {
			return "userLogin";
		}
		year = (int) session.getAttribute("Year");
		month = (int) session.getAttribute("Month") + 1;
		date = (int) session.getAttribute("Date");
		if (month == 13) {
			month -= 12;
			year++;
		}
		dateSystem = new DateSystem(date, month, year);
		fillEmptry(year, month, date);
		fillQueue(year, month);

		model.addAttribute("dates", myDateQueue);
		model.addAttribute("month", year + "/ " + getMonthString());
		model.addAttribute("selected", date);
		passToSession(session, year, month, date);

		System.out.println(year + "/ " + month + "/ " + date);

		return "checkInSystem";

	}

	private String getCurrentTime() {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd");
		LocalDateTime now = LocalDateTime.now();
		return formatter.format(now).toString();

	}

	private void fillQueue(int year, int month) {
		if (year % 4 == 0 && year % 100 != 0 && month == 2) {
			for (int num = 1; num <= 29; num++) {
				Day day = new Day();
				day.setDay(num);
				myDateQueue.add(day);

			}
		} else if (month == 2) {
			for (int num = 1; num < 29; num++) {
				Day day = new Day();
				day.setDay(num);
				myDateQueue.add(day);
			}

		} else if (month == 1 || month == 3 || month == 5 || month == 7 || month == 8 || month == 10 || month == 12)
			for (int num = 1; num < 32; num++) {
				Day day = new Day();
				day.setDay(num);
				myDateQueue.add(day);
			}

		else
			for (int num = 1; num < 31; num++) {
				Day day = new Day();
				day.setDay(num);
				myDateQueue.add(day);
			}
	}

	private void fillEmptry(int year, int month, int date) {
		myDateQueue = new ArrayDeque<>();
		int emptyBlockNum = dateSystem.getEmptyDaynumber();
		for (int num = 0; num < emptyBlockNum - 1; num++) {
			Day myDay = new Day();
			myDay.setDay(0);
			myDateQueue.add(myDay);
		}
	}

	private void passToSession(HttpSession session, int year, int month, int date) {
		session.setAttribute("Year", year);
		session.setAttribute("Month", month);
		session.setAttribute("Date", date);
	}

	private String getMonthString() {
		switch (month) {
		case 1:
			return "January";
		case 2:
			return "Februray";
		case 3:
			return "March";
		case 4:
			return "April";
		case 5:
			return "May";
		case 6:
			return "June";
		case 7:
			return "July";
		case 8:
			return "August";
		case 9:
			return "September";
		case 10:
			return "October";
		case 11:
			return "November";
		case 12:
			return "December";

		}

		return null;
	}

	public class Day {
		public int day;
		public String dayString;

		public int getDay() {
			return day;
		}

		public void setDay(int day) {
			this.day = day;
		}

		public String getDayString() {
			return dayString;
		}

		public void setDayString(String dayString) {
			this.dayString = dayString;
			day = Integer.parseInt(dayString);
		}

		@Override
		public String toString() {
			return String.valueOf(day);
		}

	}

}
