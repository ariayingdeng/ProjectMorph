package com.csis3275.morphModel;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class UserRowMapper implements RowMapper<User> {

	@Override
	public User mapRow(ResultSet rs, int rowNum) throws SQLException {
		User user = new User();
		user.setUsername(rs.getString("username"));
		user.setEmail(rs.getString("email"));
		user.setBirthdate(rs.getString("birthdate"));
		user.setPassword(rs.getString("password"));
		user.setId(rs.getInt("id"));
		return user;
	}

}
