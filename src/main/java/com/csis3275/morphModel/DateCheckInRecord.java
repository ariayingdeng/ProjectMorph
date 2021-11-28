package com.csis3275.morphModel;

import javax.persistence.Column;
import javax.persistence.Entity;

import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="checkinrecord")
public class DateCheckInRecord {	

	
	@Column(name="usernId", nullable=false, unique=false)
	private int userId;
	
	@Id
	@Column(name="date", nullable=false)
	private String date;
	
	@Column(name="eat", nullable = false)
	private boolean eat;
	
	@Column(name="exercise", nullable = false)
	private boolean exerciese;
	

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public boolean isEat() {
		return eat;
	}

	public void setEat(boolean eat) {
		this.eat = eat;
	}

	public boolean isExerciese() {
		return exerciese;
	}

	public void setExerciese(boolean exerciese) {
		this.exerciese = exerciese;
	}
	
	
}
