package com.csis3275.morphRepository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.csis3275.morphModel.Post_yde_89;

@Repository
public interface PostsRepository extends CrudRepository<Post_yde_89, Integer> {
	
}
