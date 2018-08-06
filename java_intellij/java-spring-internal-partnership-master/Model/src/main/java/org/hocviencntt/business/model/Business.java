package org.hocviencntt.business.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hocviencntt.user.model.User;

@Entity(name="business")
@Table(name="business")
public class Business {
	
	@Id
	private int id;
	@Column
	private String name;
	@Column
	private String experience;
	@Column(name="startday")
	private Date startDay;
	
	@ManyToOne
	@JoinColumn(name="username")
	User user;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getExperience() {
		return experience;
	}

	public void setExperience(String experience) {
		this.experience = experience;
	}

	public Date getStartDay() {
		return startDay;
	}

	public void setStartDay(Date startDay) {
		this.startDay = startDay;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Business(int id, String name, String experience, Date startDay, User user) {
		super();
		this.id = id;
		this.name = name;
		this.experience = experience;
		this.startDay = startDay;
		this.user = user;
	}
	
	public Business() {
		// TODO Auto-generated constructor stub
	}
	

	
}
