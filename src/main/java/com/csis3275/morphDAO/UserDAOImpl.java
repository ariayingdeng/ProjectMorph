package com.csis3275.morphDAO;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import com.csis3275.morphModel.User;

@Service
public class UserDAOImpl {
	
	JdbcTemplate jdbcTemplate;
	
	private final String SQL_CREATE_USERINFO = "INSERT INTO users (height,weight,age,gender,bodyfat) VALUES (?,?,?,?,?)";
	
	@Autowired
	public UserDAOImpl(DataSource dataSource) {
		jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	public boolean createUser(User user) {
		
		return jdbcTemplate.update(SQL_CREATE_USERINFO, user.getHeight(), user.getWeight(), user.getAge(), user.getGender(),user.getBodyFat()) > 0;
	}
}
