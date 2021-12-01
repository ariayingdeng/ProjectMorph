package com.csis3275.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.csis3275.morphModel.Post_yde_89;
import com.csis3275.morphRepository.PostsRepository;

@RunWith(SpringRunner.class)
@DataJpaTest
class PostsRepositoryTest_yde_89 {

	@Autowired
	PostsRepository postsRepo;
	
	/**
	 * Tests postsRepository save() and findById()
	 */
	@Test
	void testPostsRepository() {
		Post_yde_89 post = new Post_yde_89();
		post.setUser("YingD");
		post.setDate("1 Dec. 2021");
		post.setContent("Test posts repository");
		post.setLikes(5);
		postsRepo.save(post);
		assertNotNull(post.getPostId());
		assertEquals("YingD", postsRepo.findById(1).getUser());
		assertEquals("Test posts repository", postsRepo.findById(1).getContent());
		assertEquals("1 Dec. 2021", postsRepo.findById(1).getDate());
		assertEquals(5, postsRepo.findById(1).getLikes());
	}
}
