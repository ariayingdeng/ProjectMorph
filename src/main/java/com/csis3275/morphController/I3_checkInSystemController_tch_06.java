package com.csis3275.morphController;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayDeque;
import java.util.List;
import java.util.Queue;

import javax.servlet.http.HttpSession;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.csis3275.morphModel.DateCheckInRecord;
import com.csis3275.morphModel.DateSystem;
import com.csis3275.morphModel.User;
import com.csis3275.morphRepository.DateCheckInRecordRepository;
import com.csis3275.morphRepository.UserRepository;

@Controller
public class I3_checkInSystemController_tch_06 {

	@Autowired
	UserRepository userRepo;

	@Autowired
	DateCheckInRecordRepository dateRepo;

	DateSystem dateSystem;

	Queue<Day> myDateQueue;

	int year, month, date;

	List<DateCheckInRecord> checkList;

	User loggedUser;

	@PostMapping("/checkin")
	@RequestMapping("/checkin")
	public String checkInPage(@ModelAttribute("Day") Day day, Model model, HttpSession session) {

		if (session.getAttribute("loggedIn") != null && (boolean) session.getAttribute("loggedIn")) {
			loggedUser = userRepo.findById((int) session.getAttribute("userId"));
			model.addAttribute("loggedIn", loggedUser.getUsername());
		} else {
			return "userLogin";
		}

		getCheckInData(loggedUser.getId());

		String[] currentDate = getCurrentTime().split("/");
		year = Integer.parseInt(currentDate[0]);
		month = Integer.parseInt(currentDate[1]);
		date = Integer.parseInt(currentDate[2]);
		dateSystem = new DateSystem(date, month, year);
		fillEmptry(year, month, date);

		fillQueue(year, month, session);

		model.addAttribute("dates", myDateQueue);
		model.addAttribute("month", year + "/ " + getMonthString());
		model.addAttribute("selected", date);
		passToSession(session, year, month, date);
		
		Day tempDay = new Day();
		tempDay.setDayId(String.format("%d%d%d", year, month, date));
		checkDay(tempDay, session);
		model.addAttribute("doEat", tempDay.isEat());
		model.addAttribute("doExercise", tempDay.isExercise());
		return "checkInSystem";
	}

	@RequestMapping("/checkingByDate")
	@PostMapping("/checkingByDate")
	public String checkingPage(@ModelAttribute("Day") Day day, Model model, HttpSession session) {

		if (session.getAttribute("loggedIn") != null && (boolean) session.getAttribute("loggedIn")) {
			loggedUser = userRepo.findById((int) session.getAttribute("userId"));
			model.addAttribute("loggedIn", loggedUser.getUsername());
		} else {
			return "userLogin";
		}

		getCheckInData(loggedUser.getId());
		year = (int) session.getAttribute("Year");
		month = (int) session.getAttribute("Month");
		date = day.getDay();
		
		

		dateSystem = new DateSystem(date, month, year);
		fillEmptry(year, month, date);

		fillQueue(year, month, session);

		model.addAttribute("dates", myDateQueue);
		model.addAttribute("month", year + "/ " + getMonthString());
		model.addAttribute("selected", date);
		
		passToSession(session, year, month, date);
		
		Day tempDay = new Day();
		tempDay.setDayId(String.format("%d%d%d", year, month, date));
		checkDay(tempDay, session);
		model.addAttribute("doEat", tempDay.isEat());
		model.addAttribute("doExercise", tempDay.isExercise());

		System.out.println(year + "/ " + month + "/ " + date);

		return "checkInSystem";
	}

	@RequestMapping("/ToPrevious")
	@PostMapping("/ToPrevious")
	public String previousMonthPage(@ModelAttribute("Day") Day day, Model model, HttpSession session) {

		if (session.getAttribute("loggedIn") != null && (boolean) session.getAttribute("loggedIn")) {
			loggedUser = userRepo.findById((int) session.getAttribute("userId"));
			model.addAttribute("loggedIn", loggedUser.getUsername());
		} else {
			return "userLogin";
		}

		getCheckInData(loggedUser.getId());
		year = (int) session.getAttribute("Year");
		month = (int) session.getAttribute("Month") - 1;
		date = (int) session.getAttribute("Date");
		if (month == 0) {
			month += 12;
			year--;
		}
		dateSystem = new DateSystem(date, month, year);
		fillEmptry(year, month, date);
		fillQueue(year, month, session);

		model.addAttribute("dates", myDateQueue);
		model.addAttribute("month", year + "/ " + getMonthString());
		model.addAttribute("selected", date);
		passToSession(session, year, month, date);
		
		Day tempDay = new Day();
		tempDay.setDayId(String.format("%d%d%d", year, month, date));
		checkDay(tempDay, session);
		model.addAttribute("doEat", tempDay.isEat());
		model.addAttribute("doExercise", tempDay.isExercise());

		System.out.println(year + "/ " + month + "/ " + date);

		return "checkInSystem";

	}

	@RequestMapping("/ToNext")
	@PostMapping("/ToNext")
	public String nextMonthPage(@ModelAttribute("Day") Day day, Model model, HttpSession session) {

		if (session.getAttribute("loggedIn") != null && (boolean) session.getAttribute("loggedIn")) {
			loggedUser = userRepo.findById((int) session.getAttribute("userId"));
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

		getCheckInData(loggedUser.getId());
		dateSystem = new DateSystem(date, month, year);
		fillEmptry(year, month, date);
		fillQueue(year, month, session);

		model.addAttribute("dates", myDateQueue);
		model.addAttribute("month", year + "/ " + getMonthString());
		model.addAttribute("selected", date);
		passToSession(session, year, month, date);
		
		Day tempDay = new Day();
		tempDay.setDayId(String.format("%d%d%d", year, month, date));
		checkDay(tempDay, session);
		model.addAttribute("doEat", tempDay.isEat());
		model.addAttribute("doExercise", tempDay.isExercise());

		System.out.println(year + "/ " + month + "/ " + date);

		return "checkInSystem";

	}

	@RequestMapping("/eatClick")
	public String eatClick(HttpSession session, Model model, @ModelAttribute("Day") Day day) {
		if (session.getAttribute("loggedIn") != null && (boolean) session.getAttribute("loggedIn")) {
			loggedUser = userRepo.findById((int) session.getAttribute("userId"));
			model.addAttribute("loggedIn", loggedUser.getUsername());
		} else {
			return "userLogin";
		}
		
		year = (int) session.getAttribute("Year");
		month = (int) session.getAttribute("Month");
		date = (int) session.getAttribute("Date");
		String dateString = String.format("%d%d%d", year, month, date);
		if (!checkList.isEmpty()) {		
			int count = 1;
			for (DateCheckInRecord dateRecord : checkList) {
				if (dateRecord.getDate().equals(dateString)) {
					
					if (dateRecord.isEat()) {
						dateRecord.setEat(false);
						
						dateRepo.save(dateRecord);
						break;
					} else {
						dateRecord.setEat(true);
						
						dateRepo.save(dateRecord);
						break;
					}						
				} 
				count++;
			}
			if (count > checkList.size()) {
				DateCheckInRecord newCheckIn = new DateCheckInRecord();
				newCheckIn.setUserId(loggedUser.getId());
				newCheckIn.setDate(dateString);
				newCheckIn.setEat(true);
				newCheckIn.setExerciese(false);
				dateRepo.save(newCheckIn);
			}
		} else {
			DateCheckInRecord newCheckIn = new DateCheckInRecord();
			newCheckIn.setUserId(loggedUser.getId());
			newCheckIn.setDate(dateString);
			newCheckIn.setEat(true);
			newCheckIn.setExerciese(false);
			dateRepo.save(newCheckIn);
		}
		
		
		return "redirect:/checkin";

	}
	
	@RequestMapping("/exerciseClick")
	public String exerciseClick(HttpSession session, Model model, @ModelAttribute("Day") Day day) {
		if (session.getAttribute("loggedIn") != null && (boolean) session.getAttribute("loggedIn")) {
			loggedUser = userRepo.findById((int) session.getAttribute("userId"));
			model.addAttribute("loggedIn", loggedUser.getUsername());
		} else {
			return "userLogin";
		}
		
		year = (int) session.getAttribute("Year");
		month = (int) session.getAttribute("Month");
		date = (int) session.getAttribute("Date");
		String dateString = String.format("%d%d%d", year, month, date);
		if (!checkList.isEmpty()) {		
			int count = 1;
			for (DateCheckInRecord dateRecord : checkList) {
				if (dateRecord.getDate().equals(dateString)) {
					System.out.println("eat click" + dateString);
					if (dateRecord.isExerciese()) {
						dateRecord.setExerciese(false);
						
						dateRepo.save(dateRecord);
						break;
					} else {
						dateRecord.setExerciese(true);
						
						dateRepo.save(dateRecord);
						break;
					}						
				} 
				count++;
			}
			if (count > checkList.size()) {
				DateCheckInRecord newCheckIn = new DateCheckInRecord();
				newCheckIn.setUserId(loggedUser.getId());
				newCheckIn.setDate(dateString);
				newCheckIn.setEat(false);
				newCheckIn.setExerciese(true);
				dateRepo.save(newCheckIn);
			}
		} else {
			DateCheckInRecord newCheckIn = new DateCheckInRecord();
			newCheckIn.setUserId(loggedUser.getId());
			newCheckIn.setDate(dateString);
			newCheckIn.setEat(false);
			newCheckIn.setExerciese(true);
			dateRepo.save(newCheckIn);
		}
		
		
		return "redirect:/checkin";

	}

	private String getCurrentTime() {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd");
		LocalDateTime now = LocalDateTime.now();
		return formatter.format(now).toString();

	}

	private void fillQueue(int year, int month, HttpSession session) {
		if (year % 4 == 0 && year % 100 != 0 && month == 2) {
			for (int num = 1; num <= 29; num++) {
				Day day = new Day();
				day.setDay(num);
				day.setDayId(String.format("%d%d%d", year, month, num));
				checkDay(day, session);
				myDateQueue.add(day);

			}
		} else if (month == 2) {
			for (int num = 1; num < 29; num++) {
				Day day = new Day();
				day.setDay(num);
				day.setDayId(String.format("%d%d%d", year, month, num));
				checkDay(day, session);
				myDateQueue.add(day);

			}

		} else if (month == 1 || month == 3 || month == 5 || month == 7 || month == 8 || month == 10 || month == 12)
			for (int num = 1; num < 32; num++) {
				Day day = new Day();
				day.setDay(num);
				day.setDayId(String.format("%d%d%d", year, month, num));
				checkDay(day, session);
				myDateQueue.add(day);

			}

		else
			for (int num = 1; num < 31; num++) {
				Day day = new Day();
				day.setDay(num);
				day.setDayId(String.format("%d%d%d", year, month, num));
				checkDay(day, session);
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

	private void getCheckInData(int userId) {

		checkList = dateRepo.findByuserId(userId);

	}
	
	private void checkDay(Day day, HttpSession session) {
		
		for (DateCheckInRecord record : checkList) {
			if (day.getDayId().equals(record.getDate())) {
				day.setEat(record.isEat());
				day.setExercise(record.isExerciese());
			}
		}
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
		public String dayId;
		boolean eat;
		boolean exercise;

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

		public void setDayId(String dayId) {
			this.dayId = dayId;
		}

		@Override
		public String toString() {
			return String.valueOf(day);
		}

		public boolean isEat() {
			return eat;
		}

		public void setEat(boolean eat) {
			this.eat = eat;
		}

		public boolean isExercise() {
			return exercise;
		}

		public void setExercise(boolean exercise) {
			this.exercise = exercise;
		}

		public String getDayId() {
			return dayId;
		}

	}

}
