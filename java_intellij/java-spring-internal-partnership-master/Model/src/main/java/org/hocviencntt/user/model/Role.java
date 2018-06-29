package org.hocviencntt.user.model;

import java.util.Set;

import javax.persistence.*;

@Entity
@Table(name = "role")
public class Role {
	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	 private int id;
	
    private String name;
	
    @ManyToMany(mappedBy = "roles")

	private Set<User> users;

	    
	    public String getName() {
	        return name;
	    }

	    public int getId() {
			return id;
		}

		public void setId(int id) {
			this.id = id;
		}

		public void setName(String name) {
	        this.name = name;
	    }

	    public Set<User> getUsers() {
	        return users;
	    }

	    public void setUsers(Set<User> users) {
	        this.users = users;
	    }
}