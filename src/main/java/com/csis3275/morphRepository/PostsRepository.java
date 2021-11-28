package com.csis3275.morphRepository;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.csis3275.morphModel.Post_yde_89;


@Repository
public interface PostsRepository extends JpaRepository<Post_yde_89, Integer> {
	List<Post_yde_89> findAll(Sort sort);
	Post_yde_89 findById(int id);
}
