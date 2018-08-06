package org.hocviencntt.user.model;


import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hocviencntt.business.model.Business;
import org.hocviencntt.location.model.Location;
import org.hocviencntt.project.model.Project;
import org.hocviencntt.rating.model.Rating;

@Entity
@Table(name= "user")
public class User {
	@Id@Column(name= "username")
	private String username;

	private String password;
	@Transient
	private String passwordConfirm;
	@OneToMany(fetch = FetchType.EAGER,mappedBy = "user")
	private Set<Project> projects;
	
	@OneToMany(cascade=CascadeType.ALL,fetch=FetchType.EAGER,mappedBy="user")
	private Set<Business> listBusinesses;
	
	@OneToMany(cascade=CascadeType.ALL,fetch=FetchType.EAGER,mappedBy="user")
	private Set<Location> listLocations;
	
	@OneToOne(mappedBy="user",fetch=FetchType.EAGER)
	private Profile profile;
	
	@ManyToMany
	@JoinTable(name="user_role",
		joinColumns = @JoinColumn(name = "user"),
		inverseJoinColumns = @JoinColumn(name = "id_role"))		
	private Set<Role> roles;
	@OneToMany(cascade=CascadeType.ALL,fetch=FetchType.EAGER,mappedBy="user")
	private Set<Rating>ratings;
	
	
	
	public Set<Rating> getRatings() {
		return ratings;
	}

	public void setRatings(Set<Rating> ratings) {
		this.ratings = ratings;
	}

	public Set<Project> getProjects() {
		return projects;
	}

	public void setProjects(Set<Project> projects) {
		this.projects = projects;
	}

	public Set<Role> getRoles() {
		return roles;
	}

	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}
	
	public String getUsername() {
		return username;
	}

	public void setUsername(String userName) {
		this.username = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String passWord) {
		this.password = passWord;
	}

	public String getPasswordConfirm() {
		return passwordConfirm;
	}

	public void setPasswordConfirm(String passwordConfirm) {
		this.passwordConfirm = passwordConfirm;
	}

	public Set<Business> getListBusinesses() {
		return listBusinesses;
	}

	public void setListBusinesses(Set<Business> listBusinesses) {
		this.listBusinesses = listBusinesses;
	}

	public Set<Location> getListLocations() {
		return listLocations;
	}

	public void setListLocations(Set<Location> listLocations) {
		this.listLocations = listLocations;
	}

	public Profile getProfile() {
		return profile;
	}

	public void setProfile(Profile profile) {
		this.profile = profile;
	}

	

	public User(String username, String password, String passwordConfirm, Set<Project> projects,
			Set<Business> listBusinesses, Set<Location> listLocations, Profile profile, Set<Role> roles) {
		super();
		this.username = username;
		this.password = password;
		this.passwordConfirm = passwordConfirm;
		this.projects = projects;
		this.listBusinesses = listBusinesses;
		this.listLocations = listLocations;
		this.profile = profile;
		this.roles = roles;
	}

	public User() {
		// TODO Auto-generated constructor stub
	}
}
