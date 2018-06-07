package org.hocviencntt.rating.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hocviencntt.user.model.User;

@Entity
@Table(name="rating")
public class Rating {

	@Id
	private int id;
	@Column(name="rate")
	private float rate;
	@ManyToOne
	@JoinColumn(name="username")
	private User user;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	
	public float getRate() {
		return rate;
	}
	public void setRate(float rate) {
		this.rate = rate;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}

	
}
