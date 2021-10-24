package com.csis3275.morphRepository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.csis3275.morphModel.User;

@Repository
public interface UserRepository extends CrudRepository<User, Integer> {
<<<<<<< HEAD
	
=======

>>>>>>> development
	User findByUsername(String username);
	User findById(int id);
}
