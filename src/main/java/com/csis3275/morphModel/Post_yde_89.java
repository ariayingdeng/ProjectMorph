package com.csis3275.morphModel;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="posts")
public class Post_yde_89 {
	
	@Id
	@GeneratedValue
	private int postId;
	
	@Column(name="user", nullable=false)
	private String user;
	
	@Column(name="date", nullable=false)
	private String date;
	
	@Column(name="content", nullable=true)
	private String content;
	
	@Column(name="likes", nullable=false)
	private int likes;
	

	public Post_yde_89() {
		likes = 0;
	}

	public int getPostId() {
		return postId;
	}

	public void setPostId(int postId) {
		this.postId = postId;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public int getLikes() {
		return likes;
	}

	public void setLikes(int likes) {
		this.likes = likes;
	}
	
	
}
