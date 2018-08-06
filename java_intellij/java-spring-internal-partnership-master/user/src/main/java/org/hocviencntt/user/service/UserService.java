package org.hocviencntt.user.service;

import java.util.List;

import org.hocviencntt.user.model.User;

public interface UserService {
	public List<User> findPartnerSuggest();
	
	public User findUser(String name);
	
	public void save(User user);
	
}
