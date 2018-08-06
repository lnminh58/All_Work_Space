package org.hocviencntt.user.service;

import java.util.HashSet;
import java.util.List;

import org.hocviencntt.user.model.Role;
import org.hocviencntt.user.model.User;
import org.hocviencntt.user.repository.RoleRepository;
import org.hocviencntt.user.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;


@Service
public class UserServiceImpl implements UserService {
	@Autowired
	private UserRepository userRepository;
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;
    @Autowired
    private RoleRepository roleRepository;
    
	public List<User> findPartnerSuggest(){		
		return userRepository.findAll();		
	}
	
    public void save(User user) {
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        HashSet<Role> roles = new HashSet<Role>();
        Role role = roleRepository.findOne(1);
        roles.add(role);
        user.setRoles(roles);
        userRepository.save(user);
    }
	public User findUser(String name) {
		return userRepository.findOne(name);
	}

}
