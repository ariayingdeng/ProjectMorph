package com.csis3275.morphDAO;

import java.util.ArrayList;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import com.csis3275.morphModel.User;
import com.csis3275.morphModel.UserRowMapper;

@Service
public class UserDAOImpl {

	JdbcTemplate jdbcTemplate;
	
	private final String SQL_GET_ALL_USERS = "SELECT * FROM users";
	private final String SQL_CREATE_NEW_USER = "INSERT INTO users (username, email, birthdate, password) values (?,?,?,?)";
	
	@Autowired
	public UserDAOImpl(DataSource dataSource) {
		jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	public boolean createNewUser(User newUser) {
		return jdbcTemplate.update(SQL_CREATE_NEW_USER, newUser.getUsername(), newUser.getEmail(), newUser.getBirthdate(), newUser.getPassword()) > 0;
	}
	 
	public ArrayList<User> getAllUsers() {
		ArrayList<User> allUsers = new ArrayList<>();
		allUsers = (ArrayList<User>) jdbcTemplate.query(SQL_GET_ALL_USERS, new UserRowMapper());
		return allUsers;
	}
	
	public boolean correctUsernamePw(String username, String password) {
		ArrayList<User> allUsers = getAllUsers();
		for (User user: allUsers) {
			if (user.getUsername().equalsIgnoreCase(username) && user.getPassword().equals(password)) {
				return true;
			}
		}
		return false;
	}
}
